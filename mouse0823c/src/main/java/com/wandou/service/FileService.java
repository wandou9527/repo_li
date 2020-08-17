package com.wandou.service;

import com.wandou.model.dto.req.ReqFileUploadDTO;

/**
 * @author liming
 * @date 2020/8/16
 * @description
 */
public interface FileService {

    boolean upload(ReqFileUploadDTO reqFileUploadDTO);
}
