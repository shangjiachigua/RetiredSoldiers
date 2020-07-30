package com.caifu.controller;


import com.caifu.service.JxActivityRoomService;
import com.caifu.util.Utils;
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
 * 军休活动室  前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
@Controller
@RequestMapping("activityRoom")
public class JxActivityRoomController {

    private static final Logger logger = LoggerFactory.getLogger(JxActivityRoomController.class);

    @Autowired
    private JxActivityRoomService jxActivityRoomService;

    @RequestMapping("toActivityRoom")
    public String toActivityRoom() {
        return "view/activity/activityroom";
    }

    @RequestMapping("addActivityRoom")
    @ResponseBody
    public String addPolicy(String id, String roomName, String roomUrl) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(id)) {
                jxActivityRoomService.updateRoomById(id, roomName, roomUrl);
            } else {
                jxActivityRoomService.add(roomName, roomUrl);
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

    @GetMapping("deleteRoomById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxActivityRoomService.deleteRoomById(id);
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


}
