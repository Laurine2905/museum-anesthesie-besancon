package jfc.isis.service;

import jfc.isis.entity.ImageData;
import jfc.isis.dao.StorageRepository;
import jfc.isis.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    // Cette fonction permet d'upload une photo dans la base de données
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                // on récupere le nom du fichier
                .name(file.getOriginalFilename())
                // le type de l'image
                .type(file.getContentType())
                // le lien de l'image compressé
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            // on affiche dans la console que l'image a bien été upload
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    // byte[] correspond au type d'une photo en java
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        // on recupere la photo dans une base de donnée
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}