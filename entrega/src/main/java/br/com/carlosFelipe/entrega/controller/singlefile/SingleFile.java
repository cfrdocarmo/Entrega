package br.com.carlosFelipe.entrega.controller.singlefile;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingleFile implements br.com.carlosFelipe.entrega.controller.File {

	private static boolean isFileCreated;
	private File fileArquivoDiretorio;

	@PostMapping("/file")
	public void createLocalFile(String fileName) throws IOException {
		fileArquivoDiretorio = new File("D:\\workspace-curso-java\\entrega\\pasta\\arquivo.txt");
		isFileCreated = fileArquivoDiretorio.createNewFile();
		System.out.println(isFileCreated);
	}

	@Override
	@GetMapping("/isFile")
	public boolean isFile() {
		return isFileCreated;
	}

	@GetMapping("/nameArquivo")
	public String getName() {
		return fileArquivoDiretorio.getName();
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
