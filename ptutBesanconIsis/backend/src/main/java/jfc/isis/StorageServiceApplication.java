package jfc.isis;

import jfc.isis.service.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
//@ComponentScan("jfc.isis")
@RestController
// pour faire des actions sur l'image il faut utiliser /image
@RequestMapping("/image")
public class StorageServiceApplication {

    @Autowired
    private StorageService service;

    // on utilise la fonction upload pour uppload la photo dans notre base de donnée
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    // on peut egalement telecharger une photo (non utilise pour l'instant)
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }


    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}