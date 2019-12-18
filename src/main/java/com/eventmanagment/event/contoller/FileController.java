package com.eventmanagment.event.contoller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileController {

    private String baseDir = "/temp1/";

    private List<String> getImageNames() {
        File file = new File(baseDir);
        List<String> imageNames = new ArrayList<>();
        for (File f : file.listFiles()) {
            imageNames.add(f.getName());
        }
        return imageNames;
    }

    @GetMapping("/upload")
    public String getUploadPage(Model model) {
        model.addAttribute("imageNames", getImageNames());
        return "fileUpload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("fileVar") MultipartFile[] multipartFiles, Model model) {
        try {

            for (MultipartFile multipartFile : multipartFiles) {

                if(!multipartFile.isEmpty()) {
                    UUID uuid = UUID.randomUUID();
                    String originalName = multipartFile.getOriginalFilename();
                    String fileExtension = "";
                    if(originalName.contains(".")) {
                        fileExtension = originalName.substring(originalName.lastIndexOf("."));
                    }
                    multipartFile.transferTo(new File(baseDir + uuid.toString() + fileExtension));
                }

            }

        } catch (IOException e) {
            System.out.println("Failed to upload file: " + e.getMessage());
        }

        model.addAttribute("imageNames", getImageNames());
        return "fileUpload";
    }

    @GetMapping("/image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(baseDir + imageName);
        return Files.readAllBytes(file.toPath());
    }
}
