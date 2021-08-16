package br.com.carlosFelipe.entrega.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.carlosFelipe.entrega.model.Aluno;
import br.com.carlosFelipe.entrega.property.FileStorageProperties;
import br.com.carlosFelipe.entrega.repository.AlunoRepository;

@Service
public class AlunoService {

	final static String SEPARATOR = System.getProperty("file.separator");
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	FileStorageProperties fileStorageProperties;
	

	public Aluno adicionarAluno(MultipartFile[] file, Long matricula, String name) throws IOException {
		String diretorioRaiz = fileStorageProperties.getUploadDir() + SEPARATOR + matricula + SEPARATOR + file[0].getResource().getFilename();
		
		Path targetLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
		
		Files.copy(file[0].getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		
		return alunoRepository.save(new Aluno(name, matricula, diretorioRaiz));
	}
	
	
}
