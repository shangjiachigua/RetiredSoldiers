package com.caifu.controller;

import com.caifu.common.Result;
import com.caifu.pojo.JxArchives;
import com.caifu.service.DataService;
import com.caifu.service.JxArchivesService;
import com.caifu.sys.sysController.AbstractController;
import com.caifu.util.Util;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lyf
 * @Date: 2020/7/17 10:55
 * @Description: 档案管理控制层
 */
@Controller
@RequestMapping("/archives")
public class ArchivesController extends AbstractController {

    final static Logger logger = LoggerFactory.getLogger(ArchivesController.class);

    @Autowired
    private DataService dataService;

    @Autowired
    private JxArchivesService archivesService;

    @RequestMapping("/index")
    @RequiresPermissions("danganziliao")
    public String index(String initPage, ModelMap map){
        map.put("initPage",initPage);
        map.put("allCount",615);
        map.put("signOutCount",360);
        map.put("leaveCount",255);
        map.put("zhibu",dataService.getPDictionariesValueByType("1"));
        map.put("minzu",dataService.getPDictionariesValueByType("2"));
        map.put("hunyingzhuangkuang",dataService.getPDictionariesValueByType("4"));
        map.put("shangcandengji",dataService.getPDictionariesValueByType("5"));
        map.put("buduileibie",dataService.getPDictionariesValueByType("6"));
        map.put("ganbuleibie",dataService.getPDictionariesValueByType("7"));
        map.put("jishudengji",dataService.getPDictionariesValueByType("8"));
        map.put("zhiwudengji",dataService.getPDictionariesValueByType("13"));
        map.put("ligongdengji",dataService.getPDictionariesValueByType("12"));
        map.put("xianzhijidaiyu",dataService.getPDictionariesValueByType("9"));
        map.put("zhanyi",dataService.getPDictionariesValueByType("15"));
        map.put("teshuqingkuang",dataService.getPDictionariesValueByType("14"));
        return "view/archives/index";
    }

    @RequestMapping("/addOrEdit")
    @RequiresPermissions("danganziliao")
    public String addOrEdit(String initPage,String id, ModelMap map){
        map.put("initPage",initPage);
        map.put("id",id);
        map.put("zhibu",dataService.getPDictionariesValueByType("1"));
        map.put("minzu",dataService.getPDictionariesValueByType("2"));
        map.put("wenhuachengdu",dataService.getPDictionariesValueByType("3"));
        map.put("hunyingzhuangkuang",dataService.getPDictionariesValueByType("4"));
        map.put("shangcandengji",dataService.getPDictionariesValueByType("5"));
        map.put("buduileibie",dataService.getPDictionariesValueByType("6"));
        map.put("ganbuleibie",dataService.getPDictionariesValueByType("7"));
        map.put("jishudengji",dataService.getPDictionariesValueByType("8"));
        map.put("xianzhijidaiyu",dataService.getPDictionariesValueByType("9"));
        map.put("zhiwudengji",dataService.getPDictionariesValueByType("13"));
        map.put("teshuqingkuang",dataService.getPDictionariesValueByType("14"));
        map.put("zhanyi",dataService.getPDictionariesValueByType("15"));
        return "view/archives/addOrEdit";
    }

    @RequestMapping("/info")
    @RequiresPermissions("danganziliao")
    public String info(String initPage, ModelMap map){
        map.put("initPage",initPage);
        return "view/archives/info";
    }

    @RequestMapping("/statistics")
    @RequiresPermissions("archivesStatistics")
    public String statistics(){
        return "view/archives/statistics";
    }

    @RequestMapping("/initData")
    @RequiresPermissions("danganziliao")
    @ResponseBody
    public Result initData(){
        Result result = new Result();
        try{
            JSONObject obj = new JSONObject();
            obj.put("jiatingguanxi",dataService.getPDictionariesValueByType("11"));
            obj.put("ligongdengji",dataService.getPDictionariesValueByType("12"));
            result.setData(obj);
            result.setCode(200);
        }catch (Exception e){
            result.setCode(199);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getData")
    @RequiresPermissions("danganziliao")
    @ResponseBody
    public Result getData(int currentPage,int pageSize,JxArchives archives,String liGong,String canZhan,String age,String rwsj,String cjgzsj,String jssj){
        Result result = new Result();
        JSONObject obj = new JSONObject();
        try{
            int minCount = (currentPage - 1) * pageSize;
            String minAge = null;
            String maxAge = null;
            String minRwsj = null;
            String maxRwsj = null;
            String minCjgzsj = null;
            String maxCjgzsj = null;
            String minJssj = null;
             String maxJssj = null;
            if(StringUtils.isNotBlank(age)){
                String[] arr = age.split("-");
                String year = "";
                if(arr != null && arr.length > 0){
                    if(StringUtils.isNotBlank(arr[0])) {
                        year = Util.dateToString(null,"yyyy-MM-dd");
                        String[] yArr = year.split("-");
                        maxAge = (Integer.parseInt(yArr[0]) - Integer.parseInt(arr[0]))+"-"+yArr[1]+"-"+yArr[2];
                    }
                   if(arr.length > 1){
                       if(StringUtils.isNotBlank(arr[1])) {
                           year = Util.dateToString(null,"yyyy-MM-dd");
                           String[] yArr = year.split("-");
                           minAge = (Integer.parseInt(yArr[0]) - Integer.parseInt(arr[1]))+"-"+yArr[1]+"-"+yArr[2];
                       }
                   }
                }
            }
            if(StringUtils.isNotBlank(jssj)){
                jssj = jssj.replace(" ","");
                String[] arr = jssj.split("-");
                if(arr != null && arr.length > 0){
                   minJssj = arr[0];
                   maxJssj = arr[1];
                }
            }
            if(StringUtils.isNotBlank(cjgzsj)){
                cjgzsj = cjgzsj.replace(" ","");
                String[] arr = cjgzsj.split("-");
                if(arr != null && arr.length > 0){
                   minCjgzsj = arr[0];
                   maxCjgzsj = arr[1];
                }
            }
            if(StringUtils.isNotBlank(rwsj)){
                rwsj = rwsj.replace(" ","");
                String[] arr = rwsj.split("-");
                if(arr != null && arr.length > 0){
                   minAge = arr[0];
                   maxAge = arr[1];
                }
            }
            List<Map<String,String>> list = archivesService.getArchivesList(minCount,pageSize,archives,liGong,canZhan,minAge,maxAge,minRwsj,maxRwsj,minCjgzsj,maxCjgzsj,minJssj,maxJssj);
            if(list != null && list.size() > 0){
                for(Map<String,String> map : list){
                    String birthDate = map.get("birth_date");
                    if(StringUtils.isNotBlank(birthDate)){
                        map.put("birth_date",Util.getAgeByBirth(Util.stringToDate(birthDate,"yyyy-MM-dd"))+"");
                    }
                }
            }
            Integer count = archivesService.getArchivesListCount(archives,liGong,canZhan,minAge,maxAge,minRwsj,maxRwsj,minCjgzsj,maxCjgzsj,minJssj,maxJssj);
            obj.put("records",list);
            obj.put("total",count);
            obj.put("current",currentPage);
            obj.put("pages",(int)Math.ceil((1.0*count/pageSize)));
            obj.put("size",pageSize);
            result.setData(obj);
            result.setCode(200);
            result.setMsg("获取档案列表成功！");
        }catch (Exception e){
            result.setCode(199);
            result.setMsg("获取档案列表失败！");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/save")
    @RequiresPermissions("danganziliao")
    @ResponseBody
    public Result save(JxArchives archives, MultipartFile photo,String family,String liGong,String warfare,String special){
        Result result = new Result();
        try{
           archivesService.saveArchives(archives,photo,family,liGong,warfare,special,getUserNo());
            result.setCode(200);
        }catch (Exception e){
            result.setCode(199);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/get")
    @RequiresPermissions("danganziliao")
    @ResponseBody
    public Result get(String id){
        Result result = new Result();
        try{
            result.setData(archivesService.getInfo(id));
            result.setMsg("获取当前档案信息成功！");
            result.setCode(200);
        }catch (Exception e){
            result.setCode(199);
            result.setMsg("获取当前档案信息失败！");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/delete")
    @RequiresPermissions("danganziliao")
    @ResponseBody
    public Result delete(String id){
        Result result = new Result();
        try{
           archivesService.delete(id);
           result.setMsg("档案删除成功！");
            result.setCode(200);
        }catch (Exception e){
            result.setCode(199);
            result.setMsg("档案删除失败！");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getStatistics")
    @RequiresPermissions("archivesStatistics")
    @ResponseBody
    public Result getStatistics(String type,String dataType){
        //dataType 1.年龄分布  2.伤残情况统计 3.记功嘉奖人次  4.职级待遇分布 5.离退休参战情况
        // 6.职务等级分布 7.技术等级分布 8.部队类别分布 9.干部类别分布 10.享受长护险比例 11.享受家庭医生比例
        // 12.购买“安康通”比例 13.购买“久久关爱”比例
        Result result = new Result();
        JSONObject obj = new JSONObject();
        try{
            if("1".equals(dataType)) {
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                String[][] dates = new String[][]{{"0-49", "50岁以下"}, {"50-59", "50-59岁"}, {"60-69", "60-69岁"}, {"70-79", "70-79岁"}, {"80", "80岁以上"}};
                for (String[] s : dates) {
                    String[] arr = s[0].split("-");
                    String year = "";
                    String maxAge = "";
                    String minAge = "";
                    if (arr != null && arr.length > 0) {
                        if (StringUtils.isNotBlank(arr[0])) {
                            year = Util.dateToString(null, "yyyy-MM-dd");
                            String[] yArr = year.split("-");
                            maxAge = (Integer.parseInt(yArr[0]) - Integer.parseInt(arr[0])) + "-" + yArr[1] + "-" + yArr[2];
                        }
                        if (arr.length > 1) {
                            if (StringUtils.isNotBlank(arr[1])) {
                                year = Util.dateToString(null, "yyyy-MM-dd");
                                String[] yArr = year.split("-");
                                minAge = (Integer.parseInt(yArr[0]) - Integer.parseInt(arr[1])) + "-" + yArr[1] + "-" + yArr[2];
                            }
                        }
                    }
                    text.add(s[1]);
                    Long count = Long.parseLong(String.valueOf(archivesService.getAgeStatisticsData(minAge, maxAge, s[1], type).get("count")));
                    value.add(count);
                    if(count > max){
                        max = count;
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("2".equals(dataType)){
                List<String> text = new ArrayList<>();
                List<String> value = new ArrayList<>();
                text.add("因公");
                value.add(archivesService.getPermanentDisabilityStatisticsData("a.invalidism_communal", type).get("count"));
                text.add("因病");
                value.add(archivesService.getPermanentDisabilityStatisticsData("a.invalidism_illness", type).get("count"));
                text.add("因战");
                value.add(archivesService.getPermanentDisabilityStatisticsData("a.invalidism_warfare", type).get("count"));
                obj.put("text",text);
                obj.put("value",value);
            }else if("3".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getHonorStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("4".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getRankTreatmentStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("5".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getBattleStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("6".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getRankLevelStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("7".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getTechnologyLevelStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("8".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getTroopsTypeStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("9".equals(dataType)){
                Long max = 0L;
                List<String> text = new ArrayList<>();
                List<Long> value = new ArrayList<>();
                List<Map<String,String>> list = archivesService.getCadreTypeStatisticsData(type);
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                        text.add(map.get("name"));
                        Long count = Long.parseLong(String.valueOf(map.get("count")));
                        if(max < count){max = count;}
                        value.add(count);
                    }
                }
                obj.put("text", text);
                obj.put("max", max);
                obj.put("value", value);
            }else if("10".equals(dataType)){
                List<Map<String,String>> list = archivesService.getLongTermInsuranceStatisticsData(type);
                List<Map<String,String>> resultData = new ArrayList<>();
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                       Map<String,String> m = new HashMap<>();
                       String name = map.get("name");
                       if("1".equals(name)){
                           name = "是";
                       }else if("0".equals(name)){
                           name = "否";
                       }else{
                           name = "未知";
                       }
                       m.put("name",name);
                       m.put("value",map.get("count"));
                       resultData.add(m);
                    }
                }
                if(resultData != null && resultData.size() > 0 && resultData.size() < 2){
                    Map<String,String> add = new HashMap<>();
                    if("是".equals(resultData.get(0).get("name"))){
                        add.put("name","否");
                        add.put("value","0");
                    }else if("否".equals(resultData.get(0).get("name"))){
                        add.put("name","是");
                        add.put("value","0");
                    }
                    resultData.add(add);
                }
                obj.put("data", resultData);
            }else if("11".equals(dataType)){
                List<Map<String,String>> list = archivesService.getFamilyDoctorStatisticsData(type);
                List<Map<String,String>> resultData = new ArrayList<>();
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                       Map<String,String> m = new HashMap<>();
                       String name = map.get("name");
                       if("1".equals(name)){
                           name = "是";
                       }else if("0".equals(name)){
                           name = "否";
                       }else{
                           name = "未知";
                       }
                       m.put("name",name);
                       m.put("value",map.get("count"));
                       resultData.add(m);
                    }
                }
                if(resultData != null && resultData.size() > 0 && resultData.size() < 2){
                    Map<String,String> add = new HashMap<>();
                    if("是".equals(resultData.get(0).get("name"))){
                        add.put("name","否");
                        add.put("value","0");
                    }else if("否".equals(resultData.get(0).get("name"))){
                        add.put("name","是");
                        add.put("value","0");
                    }
                    resultData.add(add);
                }
                obj.put("data", resultData);
            }else if("12".equals(dataType)){
                List<Map<String,String>> list = archivesService.getAktStatisticsData(type);
                List<Map<String,String>> resultData = new ArrayList<>();
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                       Map<String,String> m = new HashMap<>();
                       String name = map.get("name");
                       if("1".equals(name)){
                           name = "是";
                       }else if("0".equals(name)){
                           name = "否";
                       }else{
                           name = "未知";
                       }
                       m.put("name",name);
                       m.put("value",map.get("count"));
                       resultData.add(m);
                    }
                }
                if(resultData != null && resultData.size() > 0 && resultData.size() < 2){
                    Map<String,String> add = new HashMap<>();
                    if("是".equals(resultData.get(0).get("name"))){
                        add.put("name","否");
                        add.put("value","0");
                    }else if("否".equals(resultData.get(0).get("name"))){
                        add.put("name","是");
                        add.put("value","0");
                    }
                    resultData.add(add);
                }
                obj.put("data", resultData);
            }else if("13".equals(dataType)){
                List<Map<String,String>> list = archivesService.getJjgaStatisticsData(type);
                List<Map<String,String>> resultData = new ArrayList<>();
                if(list != null && list.size() > 0){
                    for(Map<String,String> map : list){
                       Map<String,String> m = new HashMap<>();
                       String name = map.get("name");
                       if("1".equals(name)){
                           name = "是";
                       }else if("0".equals(name)){
                           name = "否";
                       }else{
                           name = "未知";
                       }
                       m.put("name",name);
                       m.put("value",map.get("count"));
                       resultData.add(m);
                    }
                }
                if(resultData != null && resultData.size() > 0 && resultData.size() < 2){
                    Map<String,String> add = new HashMap<>();
                    if("是".equals(resultData.get(0).get("name"))){
                        add.put("name","否");
                        add.put("value","0");
                    }else if("否".equals(resultData.get(0).get("name"))){
                        add.put("name","是");
                        add.put("value","0");
                    }
                    resultData.add(add);
                }
                obj.put("data", resultData);
            }
            result.setData(obj);
            result.setMsg("获取档案统计数据成功！");
            result.setCode(200);
        }catch (Exception e){
            result.setCode(199);
            result.setMsg("获取档案统计数据失败！");
            e.printStackTrace();
        }
        return result;
    }
}
