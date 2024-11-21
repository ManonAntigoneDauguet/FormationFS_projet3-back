package com.chatop.api.common;

import com.chatop.api.service.exception.PictureUploadException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class Utils {

    /**
     * Creates a unique name for a file to save
     *
     * @param file as the file to save
     * @return fileName
     */
    public static String createFileName(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String userFileName = file.getOriginalFilename();

        return "id_" +  uuid + "name_" + userFileName;
    }

    /**
     * Allows to save a file into a folder and return his unique name
     *
     * @param file as the file ti save
     * @param directoryPath as the path to the target folder
     * @return fileName as the name of the uploaded file
     */
    public static String uploadFile(MultipartFile file, String directoryPath) {
        if (!isValidPicture(file)) throw new PictureUploadException("The file must be a png or a jpg file");

        try {
            String fileName = createFileName(file);
            Path filePath = Paths.get(directoryPath, fileName);
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image saved successfully into " + filePath);
            return fileName;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw new PictureUploadException("An error occurred during image saving", e);
        }
    }

    /**
     * Return false if the file isn't a png ou jpg file
     * @param file as the file to check
     * @return boolean
     */
    public static boolean isValidPicture(MultipartFile file) {
        String userFileName = file.getOriginalFilename();
        int extensionIndex = userFileName.lastIndexOf(".");
        String fileExtension = userFileName.substring(extensionIndex +1);

        return fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg");
    }

}
