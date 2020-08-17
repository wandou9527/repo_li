package com.wandou.model.dto.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author liming
 * @date 2020/8/16
 * @description
 */

@Data
public class ReqFileUploadDTO implements Serializable {

    private String mainType;

    @NotNull(message = "文件不可为空")
    private MultipartFile file;

}
