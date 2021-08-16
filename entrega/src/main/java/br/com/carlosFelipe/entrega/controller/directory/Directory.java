package br.com.carlosFelipe.entrega.controller.directory;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Directory implements br.com.carlosFelipe.entrega.controller.File {

	private static boolean isDirectoryCreated;
	private static File fileDirectory;

	@PostMapping("/diretorios")
	public static void createLocalFolder(String folderName) throws IOException {
		fileDirectory = new File("pasta");
		isDirectoryCreated = fileDirectory.mkdir();
		System.out.println(isDirectoryCreated);
	}

	@Override
	public boolean isFile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@GetMapping("/isDirectory")
	public boolean isDirectory() {
		return isDirectoryCreated;
	}

	@Override
	public String getName() {
		return fileDirectory.getName();
	}
	



}
