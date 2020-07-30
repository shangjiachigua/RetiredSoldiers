package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.caifu.mapper.*;
import com.caifu.pojo.*;
import com.caifu.service.JxArchivesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 档案表 军休档案 服务实现类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
@Service
public class JxArchivesServiceImpl extends ServiceImpl<JxArchivesMapper, JxArchives> implements JxArchivesService {

    @Autowired
    private JxArchivesMapper archivesMapper;

    @Autowired
    private JxArchivesFamilymembersMapper archivesFamilymembersMapper;

    @Autowired
    private JxArchivesContributionMapper archivesContributionMapper;

    @Autowired
    private JxArchivesSpecialMapper archivesSpecialMapper;

    @Autowired
    private JxArchivesWarfareMapper archivesWarfareMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArchives(JxArchives archives, MultipartFile photo, String family, String liGong, String warfare, String special,int userNo) throws Exception{
        try{
            if(photo != null && !photo.isEmpty()){
                JSONObject obj = Util.uploadFile(photo,"");
                if(obj.getString("code").equals("success")){
                    archives.setPhotoUrl(obj.getString("path"));
                }
            }
            archives.setCreateBy(userNo);
            archives.setCreateTime(new Date());
            archives.setStatus("1");
            archives.setFaceState("1");

            archivesMapper.insert(archives);

            if(StringUtils.isNotBlank(special)) {
                String[] arr = warfare.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        JxArchivesSpecial as = new JxArchivesSpecial();
                        as.setArchivesId(archives.getId());
                        as.setSpecial(s);
                        archivesSpecialMapper.insert(as);
                    }
                }
            }

            if(StringUtils.isNotBlank(warfare)) {
                String[] arr = warfare.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        JxArchivesWarfare aw = new JxArchivesWarfare();
                        aw.setArchivesId(archives.getId());
                        aw.setWarfare(s);
                        archivesWarfareMapper.insert(aw);
                    }
                }
            }

            if(StringUtils.isNotBlank(liGong)) {
                JSONArray liGongArr = JSONArray.fromObject(liGong);
                if (liGongArr != null && liGongArr.size() > 0) {
                    for (int i = 0; i < liGongArr.size(); i++) {
                        JSONObject obj = liGongArr.getJSONObject(i);
                        JxArchivesContribution ac = new JxArchivesContribution();
                        ac.setArchivesId(archives.getId());
                        ac.setContributionDate(Util.stringToDate(obj.getString("time"),"yyyy"));
                        ac.setContributionLevel(String.valueOf(obj.get("level")));
                        ac.setRemarks(obj.getString("other"));
                        ac.setStatus("1");
                        archivesContributionMapper.insert(ac);
                    }
                }
            }

            if(StringUtils.isNotBlank(family)) {
                JSONArray familyArr = JSONArray.fromObject(family);
                if (familyArr != null && familyArr.size() > 0) {
                    for (int i = 0; i < familyArr.size(); i++) {
                        JSONObject obj = familyArr.getJSONObject(i);
                        JxArchivesFamilymembers af = new JxArchivesFamilymembers();
                        af.setArchivesId(archives.getId());
                        af.setContact(String.valueOf(obj.get("phone")));
                        af.setName(obj.getString("name"));
                        af.setUrgentContact(String.valueOf(obj.get("jjlxr")));
                        af.setRelation(obj.getString("relation"));
                        af.setStatus("1");
                        archivesFamilymembersMapper.insert(af);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getArchivesList(int minCount, int pageSize, JxArchives archives, String liGong, String canZhan, String minAge, String maxAge, String minRwsj, String maxRwsj, String minCjgzsj, String maxCjgzsj, String minJssj, String maxJssj) throws Exception {
        try{
            return archivesMapper.getArchivesList(minCount,pageSize,archives,liGong,canZhan,minAge,maxAge,minRwsj,maxRwsj,minCjgzsj,maxCjgzsj,minJssj,maxJssj);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取档案列表失败！");
        }
    }

    @Override
    @Transactional
    public Integer getArchivesListCount(JxArchives archives, String liGong, String canZhan, String minAge, String maxAge, String minRwsj, String maxRwsj, String minCjgzsj, String maxCjgzsj, String minJssj, String maxJssj) throws Exception {
        try{
            return archivesMapper.getArchivesListCount(archives,liGong,canZhan,minAge,maxAge,minRwsj,maxRwsj,minCjgzsj,maxCjgzsj,minJssj,maxJssj);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取档案列表失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws Exception {
        try{
            UpdateWrapper<JxArchives> uw = new UpdateWrapper<>();
            uw.lambda().set(JxArchives::getStatus,"9").eq(JxArchives::getId,id);
            archivesMapper.update(null,uw);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("删除档案失败！");
        }
    }

    @Override
    @Transactional
    public Map<String, String> getAgeStatisticsData(String startDate,String endDate,String name,String type) throws Exception{
        try{
            return archivesMapper.getAgeStatisticsData(startDate,endDate,name,type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public Map<String, String> getPermanentDisabilityStatisticsData(String filed, String type) throws Exception {
        try{
            return archivesMapper.getPermanentDisabilityStatisticsData(filed,type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getHonorStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getHonorStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getRankTreatmentStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getRankTreatmentStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getBattleStatisticsData(String type) throws Exception {
        try{
            return archivesMapper.getBattleStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getRankLevelStatisticsData(String type) throws Exception {
        try{
            return archivesMapper.getRankLevelStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getTechnologyLevelStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getTechnologyLevelStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getTroopsTypeStatisticsData(String type) throws Exception {
        try{
            return archivesMapper.getTroopsTypeStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getCadreTypeStatisticsData(String type) throws Exception {
        try{
            return archivesMapper.getCadreTypeStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getLongTermInsuranceStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getLongTermInsuranceStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getFamilyDoctorStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getFamilyDoctorStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getAktStatisticsData(String type) throws Exception {
        try{
            return archivesMapper.getAktStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public List<Map<String, String>> getJjgaStatisticsData(String type)  throws Exception{
        try{
            return archivesMapper.getJjgaStatisticsData(type);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取数据失败！");
        }
    }

    @Override
    @Transactional
    public JSONObject getInfo(String id) throws Exception {
        try{
            JSONObject obj = new JSONObject();
            JxArchives archives = archivesMapper.selectById(id);
            List<JxArchivesContribution> cList = archivesContributionMapper.selectList(new QueryWrapper<JxArchivesContribution>().eq("archives_id",id));
            List<JxArchivesFamilymembers> fList = archivesFamilymembersMapper.selectList(new QueryWrapper<JxArchivesFamilymembers>().eq("archives_id",id));
            List<JxArchivesSpecial> sList = archivesSpecialMapper.selectList(new QueryWrapper<JxArchivesSpecial>().eq("archives_id",id));
            List<JxArchivesWarfare> wList = archivesWarfareMapper.selectList(new QueryWrapper<JxArchivesWarfare>().eq("archives_id",id));
            obj.put("archives",archives);
            obj.put("cList",cList);
            obj.put("fList",fList);
            obj.put("sList",sList);
            obj.put("wList",wList);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取档案详情失败！");
        }
    }
}
