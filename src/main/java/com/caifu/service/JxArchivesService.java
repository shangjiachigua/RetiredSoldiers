package com.caifu.service;

import com.caifu.pojo.JxArchives;
import com.baomidou.mybatisplus.extension.service.IService;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 档案表 军休档案 服务类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public interface JxArchivesService extends IService<JxArchives> {

    /**
     * 功能描述: 保存军休档案
     *
     * @auther: Lyf
     * @date: 2020/7/22 14:36
     * @param:
     * @return:
     */
    void saveArchives(JxArchives archives, MultipartFile photo, String family, String liGong, String warfare, String special,int userNo)throws Exception;

    /**
     * 功能描述: 获取档案列表
     *
     * @auther: Lyf
     * @date: 2020/7/22 16:19
     * @param:
     * @return:
     */
    List<Map<String,String>> getArchivesList(int minCount,int pageSize,JxArchives archives,String liGong,String canZhan,String minAge,String maxAge,String minRwsj,String maxRwsj,String minCjgzsj,String maxCjgzsj,String minJssj,String maxJssj)throws Exception;

    /**
     * 功能描述: 获取档案列表总记录数
     *
     * @auther: Lyf
     * @date: 2020/7/23 14:13
     * @param:
     * @return:
     */
    Integer getArchivesListCount(JxArchives archives,String liGong,String canZhan,String minAge,String maxAge,String minRwsj,String maxRwsj,String minCjgzsj,String maxCjgzsj,String minJssj,String maxJssj)throws Exception;

    /**
     * 功能描述: 根据档案id删除档案
     *
     * @auther: Lyf
     * @date: 2020/7/23 18:44
     * @param:
     * @return:
     */
    void delete(String id)throws Exception;

    /**
     * 功能描述: 获取年龄分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    Map<String,String> getAgeStatisticsData(String startDate,String endDate,String name,String type) throws Exception;

    /**
     * 功能描述: 获取伤残分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    Map<String,String> getPermanentDisabilityStatisticsData(String filed,String type) throws Exception;

    /**
     * 功能描述: 获取荣誉分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getHonorStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取职级待遇分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getRankTreatmentStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取参战情况分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getBattleStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取职务等级分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getRankLevelStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取技术等级分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getTechnologyLevelStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取部队类别分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getTroopsTypeStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取干部类别分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getCadreTypeStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取长护险分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getLongTermInsuranceStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取家庭医生分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getFamilyDoctorStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取安康通分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getAktStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 获取久久关爱分布统计
     *
     * @auther: Lyf
     * @date: 2020/7/24 16:12
     * @param:
     * @return:
     */
    List<Map<String,String>> getJjgaStatisticsData(String type) throws Exception;

    /**
     * 功能描述: 根据档案编号获取档案信息（包括档案信息、家庭成员、立功情况等）
     *
     * @auther: Lyf
     * @date: 2020/7/27 13:48
     * @param:
     * @return:
     */
    JSONObject getInfo(String id)throws Exception;

}
