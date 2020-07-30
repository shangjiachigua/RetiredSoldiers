package com.caifu.controller;


import com.caifu.pojo.JxBigscreenInterval;
import com.caifu.service.JxBigscreenIntervalService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 军休大屏滚动间隔时间（秒）  前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Controller
@RequestMapping("bigscreenInterval")
public class JxBigscreenIntervalController {
    private static final Logger logger = LoggerFactory.getLogger(JxBigscreenIntervalController.class);

    @Autowired
    private JxBigscreenIntervalService jxBigscreenIntervalService;

    @GetMapping("getBigscreenInterval")
    @ResponseBody
    public String getBigscreenInterval() {
        JSONObject result = new JSONObject();
        try {
            JxBigscreenInterval bigscreenInterval = jxBigscreenIntervalService.getBigscreenInterval();
            result.put("code", "0000");
            result.put("data", bigscreenInterval.getSecond());
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("setBigscreenInterval")
    @ResponseBody
    public String setBigscreenInterval(String second) {
        JSONObject result = new JSONObject();
        try {
            jxBigscreenIntervalService.setBigscreenInterval(second);
            result.put("code", "0000");
            result.put("msg", "保存成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }
}
