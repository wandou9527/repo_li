package com.wandou.controller;

import com.wandou.common.BizException;
import com.wandou.enumeration.ReturnCodeEnum;
import com.wandou.model.dto.req.ReqFileUploadDTO;
import com.wandou.model.vo.BaseRespVO;
import com.wandou.service.FileService;
import com.wandou.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author liming
 * @date 2020/8/16
 * @description
 */

@Slf4j
@RequestMapping("/file")
@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @ResponseBody
    @PostMapping(value = "/upload")
    public BaseRespVO<Boolean> upload(@Valid ReqFileUploadDTO reqFileUploadDTO) {
        log.info("upload req: {}", reqFileUploadDTO);
        boolean flag = fileService.upload(reqFileUploadDTO);
        return BaseRespVO.success(flag);
    }

    @PostMapping("/export/excel")
    public void exportExcel(HttpServletResponse response) {
        log.info("export excel");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/force-download");
        String realFileName = "批量添加现金(积分)模板V2.xlsx";
        try {
            HSSFWorkbook excel = ExcelUtil.createTemplate(Arrays.asList("userId", "name"));
            ServletOutputStream outputStream = response.getOutputStream();
            excel.write(outputStream);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(realFileName.trim(), StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            log.error("下载模板异常 ", e);
            throw new BizException(ReturnCodeEnum.BAD_PARAM);
        }

    }

}
