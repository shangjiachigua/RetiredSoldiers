package com.caifu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.common.Result;
import com.caifu.pojo.JxPolicy;
import com.caifu.service.JxPolicyService;
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
@RequestMapping("policy")
public class JxPolicyController {

    private static final Logger logger = LoggerFactory.getLogger(JxPolicyController.class);


    @Autowired
    private JxPolicyService jxPolicyService;

    @RequestMapping("toPolicyPage")
    public String toPolicyPage() {
        return "view/policy/policy";
    }

    @GetMapping("getPolicyList")
    @ResponseBody
    public Result<Object> getPolicyList(String title, String currentPage, String pageSize) {
        Result<Object> result = new Result<>();
        try {
            IPage<JxPolicy> policyList = jxPolicyService.getPolicyList(title, currentPage, pageSize);
            result.setData(policyList);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(9999);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("toAddPolicy")
    public String toAddPolicy(String id, Model model) {
        model.addAttribute("id", id);
        return "view/policy/addpolicy";
    }

    @RequestMapping("addPolicy")
    @ResponseBody
    public String addPolicy(JxPolicy policy) {
        JSONObject result = new JSONObject();
        try {
            if (Utils.isNotNull(policy.getId())) {
                jxPolicyService.updateById(policy.getId(), policy.getBriefIntroduction(), policy.getContent(),
                        policy.getImgUrl(), policy.getTitle());
            } else {
                jxPolicyService.add(policy.getBriefIntroduction(), policy.getContent(),
                        policy.getImgUrl(), policy.getTitle());
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
            jxPolicyService.deleteById(id);
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

    @GetMapping("getPolicyById")
    @ResponseBody
    public Result<Object> getPolicyById(String id) {
        Result<Object> result = new Result<>();
        try {
            JxPolicy jxPolicy = jxPolicyService.getPolicyById(id);
            result.setData(jxPolicy);
            result.setCode(200);
        } catch (Exception e) {
            logger.error(e.toString());
            result.setMsg("网络异常");
            result.setCode(9999);
            e.printStackTrace();
        }
        return result;
    }
}
