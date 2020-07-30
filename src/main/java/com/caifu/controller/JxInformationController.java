package com.caifu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.common.Result;
import com.caifu.dto.JxInformationDto;
import com.caifu.pojo.JxInformation;
import com.caifu.service.JxInformationService;
import com.caifu.service.JxInformationTypeService;
import com.caifu.util.Utils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 军休资料 前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Controller
@RequestMapping("information")
public class JxInformationController {

    private static final Logger logger = LoggerFactory.getLogger(JxInformationController.class);

    @Autowired
    private JxInformationService jxInformationService;

    @Autowired
    private JxInformationTypeService jxInformationTypeService;

    @RequestMapping("toInformationPage")
    public String toInformationPage() {
        return "view/information/information";
    }

    @GetMapping("getInformation")
    @ResponseBody
    public Result<Object> getInformation(String currentPage, String pageSize, String title, String type) {
        Result<Object> result = new Result<>();
        try {
            IPage<JxInformation> information = jxInformationService.getInformation(currentPage, pageSize, title, type);
            result.setCode(200);
            result.setData(information);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("toAddInformation")
    public String toAddInformation(String id, Model model) {
        model.addAttribute("id", id);
        return "view/information/addinformation";
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxInformationService.deleteById(id);
            result.put("code", "0000");
            result.put("msg", "删除成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    @PostMapping("addInformation")
    @ResponseBody
    public String addInformation(JxInformationDto jxInformationDto) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(jxInformationDto.getId())) {
                jxInformationService.updateInformationById(jxInformationDto);
            } else {
                jxInformationService.add(jxInformationDto);
            }
            result.put("code", "0000");
            result.put("msg", "保存成功");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("code", "9999");
            result.put("msg", "网络异常");
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("getInformationById")
    @ResponseBody
    public Result<Object> getInformationById(String id) {
        Result<Object> result = new Result<>();
        try {
            JxInformation information = jxInformationService.getInformationById(id);
            result.setData(information);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(500);
            e.printStackTrace();
        }
        return result;
    }

}
