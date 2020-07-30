package com.caifu.controller;


import com.caifu.common.Result;
import com.caifu.pojo.JxInformationFile;
import com.caifu.service.JxInformationFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 军休资料附件 前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Controller
@RequestMapping("informationfile")
public class JxInformationFileController {

    private static final Logger logger = LoggerFactory.getLogger(JxInformationController.class);


    @Autowired
    private JxInformationFileService jxInformationFileService;

    @GetMapping("getInformationfileById")
    @ResponseBody
    public Result<Object> getInformationfileById(String informationId) {
        Result<Object> result = new Result<>();
        try {
            List<JxInformationFile> informationfiles = jxInformationFileService.getInformationfileById(informationId);
            result.setData(informationfiles);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(9999);
            e.printStackTrace();
        }
        return result;
    }
}
