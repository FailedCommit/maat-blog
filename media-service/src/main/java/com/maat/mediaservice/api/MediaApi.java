package com.maat.mediaservice.api;

import com.maat.mediaservice.beans.MediaObject;
import com.maat.mediaservice.dto.MediaUploadRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaApi {
    @GetMapping("/hi")
    public String sayHi() {
        return "Hello there!! media..";
    }

    @PostMapping("/upload")
    public ResponseEntity<MediaObject> upload(MediaUploadRequest request) {
        //TODO: Implement logic to upload to Amazon S3
        //TODO: Save the S3 Url and other meta data to Mongo DB
        log.info("Uploaded to Amazon S3");
        return null;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<MediaObject> download(@PathVariable("id") String id) {
        //TODO: Implement logic to download from Amazon S3
        log.info("Downloaded from Amazon S3 with id: {}", id);
        return null;
    }
}
