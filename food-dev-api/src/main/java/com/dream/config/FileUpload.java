package com.dream.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-05
 */

@Component
@ConfigurationProperties("file.space")
@PropertySource("classpath:center.properties")
public class FileUpload {


    private String uploadPath;


    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
