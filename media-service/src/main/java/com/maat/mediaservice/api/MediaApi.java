package com.maat.mediaservice.api;

import com.maat.mediaservice.dto.MediaUploadResponse;
import com.maat.mediaservice.storage.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaApi {
    private final StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> upload(@RequestParam("files") MultipartFile[] files) {
        //TODO: Implement logic to upload to Amazon S3
        //TODO: Save the S3 Url and other meta data to Mongo DB
        log.info("Uploaded to Amazon S3");
        List<String> uploadedFiles = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                storageService.store(file);
                uploadedFiles.add("Uploaded the file successfully: " + file.getOriginalFilename());
            }
            return ResponseEntity.status(HttpStatus.OK).body(uploadedFiles);
        } catch (Exception e) {
            log.error("Fail to upload files! ", e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(uploadedFiles);
        }
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
