package com.worstEzreal.tess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

/**
 * Desc
 *
 * @date 2018/7/2
 */
//@Configuration
public class MvcConfig {
//    @Bean
//    public MultipartResolver multipartResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setMaxUploadSize(10485760);
//        //上传文件的临时路径，上传完成后会自动删除
//        resolver.setUploadTempDir(new PathResource("upload/temp"));
//        return resolver;
//    }
}
