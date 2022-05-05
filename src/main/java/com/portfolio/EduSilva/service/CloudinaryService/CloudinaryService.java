package com.portfolio.EduSilva.service.CloudinaryService;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService() {
        valuesMap.put("cloud_name", "dmfuwxcez");
        valuesMap.put("api_key", "357897132274419");
        valuesMap.put("api_secret", "4n_cBuvCqt1hXZRhvbklD1LuhCA");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map uploadPortada(MultipartFile multipartFile) throws IOException {

        File file = convert(multipartFile);

        // Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("transformation",
                  new Transformation().quality("auto").fetchFormat("auto").flags("lossy").background("auto").gravity("auto").height(400).width(1000).crop("fill_pad")));
        

        file.delete();
        return result;
    }

    public Map uploadFoto(MultipartFile multipartFile) throws IOException {

        File file = convert(multipartFile);

        // Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("transformation",
                new Transformation().quality("auto").fetchFormat("auto").gravity("face").height(200).width(200).crop("thumb").chain()
                        .radius("max")));

        file.delete();
        return result;
    }

    public Map uploadProyectoImagenes(MultipartFile multipartFile) throws IOException {

        File file = convert(multipartFile);

        // Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("transformation",
                new Transformation().quality("auto").fetchFormat("auto").background("black").height(300).width(300).flags("lossy").crop("pad")));

        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
