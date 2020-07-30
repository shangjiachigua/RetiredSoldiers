package com.caifu.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.common.Result;
import com.caifu.dto.JxActivityDto;
import com.caifu.pojo.JxActivity;
import com.caifu.pojo.JxActivityMenber;
import com.caifu.pojo.JxActivityRoom;
import com.caifu.service.JxActivityService;
import com.caifu.util.Utils;
import com.github.pagehelper.PageInfo;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 军休活动  前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
@Controller
@RequestMapping("activity")
public class JxActivityController {

    private static final Logger logger = LoggerFactory.getLogger(JxActivityController.class);

    @Autowired
    private JxActivityService jxActivityService;

    @RequestMapping("toActivityPage")
    public String toActivityPage() {
        return "view/activity/activity";
    }

    @GetMapping("getActivityList")
    @ResponseBody
    public Result<Object> getActivityList(String title, String currentPage, String pageSize, String status) {
        Result<Object> result = new Result<>();
        try {
            PageInfo<JxActivityDto> activityList = jxActivityService.getActivityList(title, currentPage, pageSize, status);
            result.setData(activityList);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(500);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("cancelPublish")
    @ResponseBody
    public String cancelPublish(String id) {
        JSONObject result = new JSONObject();
        try {
            jxActivityService.cancelPublish(id);
            result.put("msg", "取消成功");
            result.put("code", "0000");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("msg", "网络异常");
            result.put("code", "9999");
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("publish")
    @ResponseBody
    public String publish(String id) {
        JSONObject result = new JSONObject();
        try {
            jxActivityService.publish(id);
            result.put("msg", "发布成功");
            result.put("code", "0000");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("msg", "网络异常");
            result.put("code", "9999");
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxActivityService.deleteById(id);
            result.put("msg", "删除成功");
            result.put("code", "0000");
        } catch (Exception e) {
            logger.error(e.toString());
            result.put("msg", "网络异常");
            result.put("code", "9999");
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping("toAddActivity")
    public String toAddActivity(String id, Model model) {
        model.addAttribute("id", id);
        return "view/activity/addactivity";
    }

    @RequestMapping("toActivityInfo")
    public String toActivityInfo(String id, Model model) {
        model.addAttribute("id", id);
        return "view/activity/preview";
    }

    @GetMapping("getActivityInfoById")
    @ResponseBody
    public Result<Object> getActivityInfoById(String id) {
        Result<Object> result = new Result<>();
        try {
            result.setCode(200);
            result.setData(jxActivityService.getActivityInfoById(id));
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("getActivityById")
    @ResponseBody
    public Result<Object> getActivityById(String id) {
        Result<Object> result = new Result<>();
        try {
            result.setCode(200);
            result.setData(jxActivityService.getActivityById(id));
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("toPersonInfo")
    public String toPersonInfo(String id, Model model) {
        model.addAttribute("activityId", id);
        return "view/activity/personInfo";
    }

    @GetMapping("getPersonInfoByActivityId")
    @ResponseBody
    public Result<Object> getPersonInfoByActivityId(String name, String activityId, String currentPage, String pageSize) {
        Result<Object> result = new Result<>();
        try {
            IPage<JxActivityMenber> pageList = jxActivityService.getPersonInfoByActivityId(name, activityId, currentPage, pageSize);
            result.setCode(200);
            result.setData(pageList);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("exportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse response, String activityId) {
        try {
            List<JxActivityMenber> exportExcelList = jxActivityService.getExportExcelList(activityId);
            String name = System.currentTimeMillis() + ".xlsx";
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
            EasyExcel.write(response.getOutputStream(), JxActivityMenber.class).sheet("用户列表").doWrite(exportExcelList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("getActivityRoom")
    @ResponseBody
    public Result<Object> getActivityRoom(String currentPage, String pageSize) {
        Result<Object> result = new Result<>();
        try {
            if (Utils.isNull(currentPage) && Utils.isNull(pageSize)) {
                List<JxActivityRoom> activityRoomList = jxActivityService.getActivityRoomList();
                result.setCode(200);
                result.setData(activityRoomList);
            } else {
                IPage<JxActivityRoom> activityRooms = jxActivityService.getActivityRoom(currentPage, pageSize);
                result.setCode(200);
                result.setData(activityRooms);
            }
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }


    @GetMapping("getActivityRoomById")
    @ResponseBody
    public Result<Object> getActivityRoomById(String id) {
        Result<Object> result = new Result<>();
        try {
            JxActivityRoom activityRoomById = jxActivityService.getActivityRoomById(id);
            result.setCode(200);
            result.setData(activityRoomById);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }


    @PostMapping("addActivity")
    @ResponseBody
    public String addActivity(JxActivity activity) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(activity.getId())) {
                jxActivityService.updateActivityById(activity);
            } else {
                jxActivityService.add(activity);
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
