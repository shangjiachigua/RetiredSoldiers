package com.caifu.controller;


import com.caifu.common.Result;
import com.caifu.dto.JxJournalismDto;
import com.caifu.pojo.JxJournalism;
import com.caifu.service.JxJournalismService;
import com.caifu.util.Utils;
import com.github.pagehelper.PageInfo;
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
 * 新闻信息表 前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-22
 */
@Controller
@RequestMapping("/news")
public class JxJournalismController {

    private static final Logger logger = LoggerFactory.getLogger(JxBriefIntroductionController.class);

    @Autowired
    private JxJournalismService jxJournalismService;

    @RequestMapping("toNewsPage")
    public String toNewsPage() {
        return "view/news/news";
    }

    @GetMapping("getNewsList")
    @ResponseBody
    public Result<Object> getNewsList(String title, String isTop, String currentPage, String pageSize) {
        Result<Object> result = new Result<>();
        try {
            PageInfo<JxJournalismDto> newsList = jxJournalismService.getNewsList(title, isTop, currentPage, pageSize);
            result.setCode(200);
            result.setData(newsList);
        } catch (Exception e) {
            result.setCode(9999);
            result.setMsg("网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxJournalismService.deleteById(id);
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

    @GetMapping("getNewsById")
    @ResponseBody
    public Result<Object> getPolicyById(String id) {
        Result<Object> result = new Result<>();
        try {
            JxJournalism jxJournalism = jxJournalismService.getPolicyById(id);
            result.setData(jxJournalism);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(9999);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("toAddNews")
    public String toAddPolicy(String id, Model model) {
        model.addAttribute("id", id);
        return "view/news/addnews";
    }

    @GetMapping("countGrass")
    @ResponseBody
    public String countGrass() {
        JSONObject result = new JSONObject();
        try {
            Integer count = jxJournalismService.countGrass();
            result.put("count", count);
            result.put("code", "0000");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("msg", "网络异常");
            result.put("code", "9999");
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("grassOrCancel")
    @ResponseBody
    public String grassOrCancel(String id, String isTop) {
        JSONObject result = new JSONObject();
        try {
            jxJournalismService.grassOrCancel(id, isTop);
            result.put("msg", "成功");
            result.put("code", "0000");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("msg", "网络异常");
            result.put("code", "9999");
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping("addNews")
    @ResponseBody
    public String addPolicy(JxJournalism jxJournalism) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(jxJournalism.getId())) {
                jxJournalismService.updateById(jxJournalism.getId(), jxJournalism.getBriefIntroduction(), jxJournalism.getContent(),
                        jxJournalism.getImgUrl(), jxJournalism.getTitle());
            } else {
                jxJournalismService.add(jxJournalism.getBriefIntroduction(), jxJournalism.getContent(),
                        jxJournalism.getImgUrl(), jxJournalism.getTitle());
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
}
