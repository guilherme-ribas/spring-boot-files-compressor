package com.example.file_compressor.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/api")
public class ZipController {

    @PostMapping("/zipFiles")
    public ResponseEntity<byte[]> zipFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);

        for (MultipartFile file : files) {
            if (file == null || file.getOriginalFilename() == null) {
                continue;
            }

            zipOutputStream.putNextEntry(new ZipEntry(file.getOriginalFilename()));
            zipOutputStream.write(file.getBytes());
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=files.zip");

        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}
