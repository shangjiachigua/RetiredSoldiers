package com.caifu.controller;


import com.caifu.common.Result;
import com.caifu.pojo.JxInformationType;
import com.caifu.service.JxInformationTypeService;
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
 * 军休资料类型 前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Controller
@RequestMapping("informationType")
public class JxInformationTypeController {

    private static final Logger logger = LoggerFactory.getLogger(JxInformationController.class);

    @Autowired
    private JxInformationTypeService jxInformationTypeService;

    @GetMapping("getInformationType")
    @ResponseBody
    public Result<Object> getInformationType() {
        Result<Object> result = new Result<>();
        try {
            List<JxInformationType> informationTypes = jxInformationTypeService.getInformationType();
            result.setCode(200);
            result.setData(informationTypes);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }
}
