package com.zeragon.forum.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final Path rootLocation = Paths.get("uploads");

    public void store(MultipartFile file) {
        try {
            Files.createDirectories(rootLocation);

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(UUID.randomUUID() + "-" + file.getOriginalFilename())).normalize().toAbsolutePath();

            file.transferTo(destinationFile);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось сохранить файл", e);
        }
    }
}