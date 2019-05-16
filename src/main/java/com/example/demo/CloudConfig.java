package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CloudConfig {
private Cloudinary cloudinary;
@Autowired
public CloudinaryConfig(@Value("${cloud.key}") String Key,
                        @Value("${cloud.secret}") String secret,
                        @Value("${cloud.name}") String cloud {
    cloudinary = Singleton.getCloudinary();
    cloudinary.config.cloudName=cloud;
    cloudinary.config.apiSecret=secret;
    cloudinary.config.apiKey=Key;
}

    public Cloudinary getCloudinary() {
        return cloudinary;
    }

    public Map upload(Object file, Map options){
    try{
        return cloudinary.uploader().upload(file, options);
    }  catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

Public String createUrl(String name, int width,
                        int height, String action){
    return cloudinary.url()
            .transformation(new Transformation()
            .width(width).height(height)
            .boarder("2px_solid_black").crop(action))
            .imageTag(name);
    }
}
.