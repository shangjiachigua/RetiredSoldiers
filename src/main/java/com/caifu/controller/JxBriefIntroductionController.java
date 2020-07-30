package com.caifu.controller;


import com.caifu.common.Result;
import com.caifu.pojo.JxBriefIntroduction;
import com.caifu.service.JxBriefIntroductionService;
import com.caifu.util.Utils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-21
 */
@Controller
@RequestMapping("introduction")
public class JxBriefIntroductionController {
    private static final Logger logger = LoggerFactory.getLogger(JxBriefIntroductionController.class);


    @Autowired
    private JxBriefIntroductionService jxBriefIntroductionService;

    @RequestMapping("toIntroductionPage")
    public String toIntroductionPage() {
        return "view/briefIntroduction/briefIntroduction";
    }

    @RequestMapping("toAddPage")
    public String toAddPage(String id, Model model) {
        model.addAttribute("id", id);
        return "view/briefIntroduction/addbriefIntroduction";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(String content, String id) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(id)) {
                jxBriefIntroductionService.updateById(id, content);
            } else {
                jxBriefIntroductionService.add(content);
            }
            result.put("code", "0000");
            result.put("msg", "成功");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("code", "9999");
            result.put("msg", "网络异常");
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("getIntroduction")
    @ResponseBody
    public Result<JxBriefIntroduction> getIntroduction() {
        Result<JxBriefIntroduction> result = new Result<>();
        try {
            result = jxBriefIntroductionService.getIntroduction();
        } catch (Exception e) {
            result.setCode(9999);
            result.setMsg("网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("getIntroductionById")
    @ResponseBody
    public Result<JxBriefIntroduction> getIntroductionById(String id) {
        Result<JxBriefIntroduction> result = new Result<>();
        try {
            result = jxBriefIntroductionService.getIntroductionById(id);
        } catch (Exception e) {
            result.setCode(9999);
            result.setMsg("网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result;
    }


    @GetMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxBriefIntroductionService.deleteById(id);
            result.put("code", "0000");
            result.put("msg", "成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }
}
