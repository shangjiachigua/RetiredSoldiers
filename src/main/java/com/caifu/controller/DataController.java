package com.caifu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.pojo.PDictionariesType;
import com.caifu.pojo.PDictionariesValue;
import com.caifu.service.DataService;
import com.caifu.util.Utils;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName DataController.java
 * @createTime 2020年07月15日 14:37
 **/
@RequestMapping("data")
@Controller
public class DataController {
    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    //跳转数据页
    @RequestMapping("toDataPage")
    @RequiresPermissions("danganguanli")
    public String toDataPage() {
        return "view/data/data";
    }

    //获取数据类型
    @GetMapping("getPDictionariesTypeList")
    @ResponseBody
    public String getPDictionariesTypeList() {
        JSONObject result = new JSONObject();
        try {
            List<PDictionariesType> pDictionariesTypeList = dataService.getPDictionariesTypeList();
            result.put("code", "0000");
            result.put("data", pDictionariesTypeList);
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    //新增基础数据
    @PostMapping("addPDictionariesValue")
    @ResponseBody
    public String addPDictionariesValue(String name, String type, String id) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(id)) {
                Map<String, Object> map = dataService.updatePDictionariesValue(name, type, id);
                result.put("code", "0000");
                result.put("msg", map.get("msg"));
            } else {
                Map<String, Object> map = dataService.addPDictionariesValue(name, type);
                result.put("code", "0000");
                result.put("msg", map.get("msg"));
            }
        } catch (ParseException e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    //更新基础数据
    @PostMapping("updatePDictionariesValue")
    @ResponseBody
    public String updatePDictionariesValue(String name, String type, String id) {
        JSONObject result = new JSONObject();
        try {
            Map<String, Object> map = dataService.updatePDictionariesValue(name, type, id);
            result.put("code", "0000");
            result.put("msg", map.get("msg"));
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result.toString();
    }

    //删除基础数据
    @PostMapping("deletePDictionariesValueById")
    @ResponseBody
    public String deletePDictionariesValue(String id) {
        JSONObject result = new JSONObject();
        try {
            dataService.deletePDictionariesValue(id);
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

    //根据科目查询基础数据
    @RequestMapping("getPDictionariesValueByType")
    @ResponseBody
    public JSONObject getPDictionariesValueByType(String type, String currentPage, String pageSize) {
        JSONObject result = new JSONObject();
        try {
            IPage<PDictionariesValue> data = dataService.getPDictionariesValueByType(type, currentPage, pageSize);
            result.put("code", "0000");
            result.put("data", data.getRecords());
            result.put("total", data.getTotal());
            result.put("totalPage", data.getPages());
            result.put("currentPage", data.getCurrent());
        } catch (Exception e) {
            result.put("code", "9999");
            result.put("msg", "网络异常");
            logger.error(e.toString());
            e.printStackTrace();
        }
        return result;
    }

}
