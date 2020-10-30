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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

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
    public BaseRespVO<Boolean> upload(HttpServletRequest request, @Valid ReqFileUploadDTO reqFileUploadDTO) {
        log.info("upload req: {}", reqFileUploadDTO);
        log.info("request: {}", request);
        String queryString = request.getQueryString();
        log.info("queryString: {}", queryString);
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println(entry.getKey() + "-" + Arrays.toString(entry.getValue()));
        }
        log.info("parameterMap: {}", parameterMap);
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("headerNames: {}", headerNames);
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
