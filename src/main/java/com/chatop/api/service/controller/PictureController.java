package com.chatop.api.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PictureController {

    @Value("${path.saving.picture}")
    private String pathSavingPicture;

    /**
     * Returns the saved picture
     *
     * @param fileName as the name with which the file is saved
     * @return ResponseEntity<Resource>
     * @throws IOException
     */
    @GetMapping("/pictures/{fileName}")
    public ResponseEntity<Resource> getPicture(@PathVariable String fileName) throws IOException {
        Path filePath = Paths.get(pathSavingPicture, fileName);
        Resource resource = new UrlResource(filePath.toUri());
        String contentType = Files.probeContentType(filePath);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
