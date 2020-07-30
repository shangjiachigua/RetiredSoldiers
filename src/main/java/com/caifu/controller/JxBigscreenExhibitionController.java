package com.caifu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.pojo.JxBigscreenExhibition;
import com.caifu.service.JxBigscreenExhibitionService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 军休大屏展示  前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Controller
@RequestMapping("bigscreen")
public class JxBigscreenExhibitionController {

    private static final Logger logger = LoggerFactory.getLogger(JxBigscreenExhibitionController.class);


    @Autowired
    private JxBigscreenExhibitionService jxBigscreenExhibitionService;

    @RequestMapping("toBigscreenPage")
    public String toBigscreenPage() {
        return "view/bigscreen/bigscreenset";
    }

    @GetMapping("getBigscreenList")
    @ResponseBody
    public String getBigscreenList(String type, String currentPage, String pageSize) {
        JSONObject result = new JSONObject();
        try {
            IPage<JxBigscreenExhibition> bigscreenList = jxBigscreenExhibitionService.getBigscreenList(type, currentPage, pageSize);
            result.put("code", "0000");
            result.put("data", bigscreenList);
            result.put("pages",bigscreenList.getPages());
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping("upload")
    @ResponseBody
    public String uploadImage(MultipartFile file, String type) {
        JSONObject result = new JSONObject();
        try {
            jxBigscreenExhibitionService.uploadImage(file, type);
            result.put("code", "0000");
            result.put("msg", "上传成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    @PostMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxBigscreenExhibitionService.deleteById(id);
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

    @PostMapping("showOrNotShow")
    @ResponseBody
    public String showOrNotShow(String id, String flag) {
        JSONObject result = new JSONObject();
        try {
            jxBigscreenExhibitionService.showOrNotShow(id, flag);
            result.put("code", "0000");
            result.put("msg", "设置成功");
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

}
