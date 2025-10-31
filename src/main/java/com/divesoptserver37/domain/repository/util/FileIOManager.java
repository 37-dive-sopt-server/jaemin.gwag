package com.divesoptserver37.domain.repository.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileIOManager {
	private final Path filePath;

	public FileIOManager(@Value("${file.path}") String path) {
		this.filePath = Paths.get(path);
	}

	public ObjectOutputStream openObjectWriter() throws IOException {
		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		return new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(filePath)));
	}

	public boolean isFileEmpty() throws IOException {
		return !Files.exists(filePath) || Files.size(filePath) == 0;
	}

	public ObjectInputStream openObjectReader() throws IOException {
		if (isFileEmpty()) {
			return null;
		}
		return new ObjectInputStream(new BufferedInputStream(Files.newInputStream(filePath)));
	}
}
