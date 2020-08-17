package com.wandou.service.impl;

import com.wandou.constant.CommonConst;
import com.wandou.model.dto.req.ReqFileUploadDTO;
import com.wandou.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author liming
 * @date 2020/8/16
 * @description
 */

@Service
public class FileServiceImpl implements FileService {

    @Override
    public boolean upload(ReqFileUploadDTO reqFileUploadDTO) {
        String filePath = "/www/file/";
        MultipartFile file = reqFileUploadDTO.getFile();
        String originalFilename = file.getOriginalFilename();
        LocalDateTime localDateTime = LocalDateTime.now();
        String targetFileName =
                localDateTime.format(DateTimeFormatter.ofPattern(CommonConst.PATTERN_YYYYMMDDHHMMSSSSS)) +
                        "_" +
                        originalFilename;
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(
                    new FileOutputStream(new File(filePath + File.separator + targetFileName)));
            out.write(file.getBytes());
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
