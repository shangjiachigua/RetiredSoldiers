package com.caifu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.common.Result;
import com.caifu.pojo.JxStaff;
import com.caifu.service.JxStaffService;
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
 * 军休员工  前端控制器
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Controller
@RequestMapping("staff")
public class JxStaffController {

    private static final Logger logger = LoggerFactory.getLogger(JxStaffController.class);

    @Autowired
    private JxStaffService jxStaffService;

    @RequestMapping("toStaffPage")
    public String toStaffPage(String id, Model model) {
        model.addAttribute("id", id);
        return "view/staff/staff";
    }

    @GetMapping("getStaffList")
    @ResponseBody
    public Result<Object> getStaffList(String currentPage,String pageSize) {
        Result<Object> result = new Result<>();
        try {
            IPage<JxStaff> staffList = jxStaffService.getStaffList(currentPage, pageSize);
            result.setCode(200);
            result.setData(staffList);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setCode(500);
            result.setMsg("网络异常");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("addStaff")
    @ResponseBody
    public String updateStaff(String id, String name, String photoUrl, String isExhibition) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(id)) {
                jxStaffService.updateRoomById(id, name, photoUrl,isExhibition);
            } else {
                jxStaffService.add(name, photoUrl,isExhibition);
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

    @RequestMapping("deleteById")
    @ResponseBody
    public String deleteById(String id) {
        JSONObject result = new JSONObject();
        try {
            jxStaffService.deleteById(id);
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
