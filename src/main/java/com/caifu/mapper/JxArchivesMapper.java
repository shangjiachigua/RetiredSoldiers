package com.caifu.mapper;

import com.caifu.pojo.JxArchives;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 档案表 军休档案 Mapper 接口
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public interface JxArchivesMapper extends BaseMapper<JxArchives> {

    /**
     * 功能描述: 获取档案列表
     *
     * @auther: Lyf
     * @date: 2020/7/22 16:19
     * @param:
     * @return:
     */
    List<Map<String,String>> getArchivesList(@Param("minCount") int minCount, @Param("pageSize") int pageSize, @Param("archives") JxArchives archives, @Param("liGong") String liGong, @Param("canZhan") String canZhan,@Param("minAge") String minAge,@Param("maxAge") String maxAge,@Param("minRwsj") String minRwsj,@Param("maxRwsj") String maxRwsj,@Param("minCjgzsj") String minCjgzsj,@Param("maxCjgzsj") String maxCjgzsj,@Param("minJssj") String minJssj,@Param("maxJssj") String maxJssj);

    /**
     * 功能描述: 获取档案列表总记录数
     *
     * @auther: Lyf
     * @date: 2020/7/23 14:12
     * @param:
     * @return:
     */
    Integer getArchivesListCount(@Param("archives") JxArchives archives, @Param("liGong") String liGong, @Param("canZhan") String canZhan,@Param("minAge") String minAge,@Param("maxAge") String maxAge,@Param("minRwsj") String minRwsj,@Param("maxRwsj") String maxRwsj,@Param("minCjgzsj") String minCjgzsj,@Param("maxCjgzsj") String maxCjgzsj,@Param("minJssj") String minJssj,@Param("maxJssj") String maxJssj);

    @Select("<script>"+
            " select #{name} as name,count(*) as count from jx_archives a where a.status = '1'" +
            " <if test='startDate != null and startDate != &quot;&quot;'>"+
            " and date_format(birth_date,'%Y-%m-%d') &gt;= #{startDate}" +
            " </if>" +
            " <if test='endDate != null and endDate != &quot;&quot;'>"+
            " and date_format(birth_date,'%Y-%m-%d') &lt;= #{endDate}" +
            " </if>" +
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " </script>")
    Map<String,String> getAgeStatisticsData(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("name") String name, @Param("type") String type);

    @Select("<script>"+
            " select count(*) as count from jx_archives a where a.status = '1' and ${filed} = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " </script>")
    Map<String,String> getPermanentDisabilityStatisticsData(@Param("filed") String filed,@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,t.id,t.name,t.archives_id from (select a.archives_id,b.id,b.name from jx_archives_contribution a left join p_dictionaries_value b on a.contribution_level = b.id left join jx_archives c on a.archives_id = c.id where b.type = '12' and c.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and c.type = #{type}"+
            " </if>" +
            " ) t group by t.id,t.name,t.archives_id) y on z.id = y.id where z.type = '12' order by z.sort"+
            " </script>")
    List<Map<String,String>> getHonorStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,b.id,a.id as archives_id,b.name from jx_archives a left join p_dictionaries_value b on a.now_treatment = b.id where b.type = '9' and a.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " group by b.id,b.name,a.id) y on z.id = y.id where z.type = '9' order by z.sort"+
            " </script>")
    List<Map<String,String>> getRankTreatmentStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,t.id,t.name,t.archives_id from (select a.archives_id,b.id,b.name from jx_archives_warfare a left join p_dictionaries_value b on a.warfare = b.id left join jx_archives c on a.archives_id = c.id where b.type = '15' and c.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and c.type = #{type}"+
            " </if>" +
            " ) t group by t.id,t.name,t.archives_id) y on z.id = y.id where z.type = '15' order by z.sort"+
            " </script>")
    List<Map<String,String>> getBattleStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,b.id,a.id as archives_id,b.name from jx_archives a left join p_dictionaries_value b on a.duties_level = b.id where b.type = '13' and a.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " group by b.id,b.name,a.id) y on z.id = y.id where z.type = '13' order by z.sort"+
            " </script>")
    List<Map<String,String>> getRankLevelStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,b.id,a.id as archives_id,b.name from jx_archives a left join p_dictionaries_value b on a.skill_level = b.id where b.type = '8' and a.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " group by b.id,b.name,a.id) y on z.id = y.id where z.type = '8' order by z.sort"+
            " </script>")
    List<Map<String,String>> getTechnologyLevelStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,b.id,a.id as archives_id,b.name from jx_archives a left join p_dictionaries_value b on a.troops_type = b.id where b.type = '6' and a.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " group by b.id,b.name,a.id) y on z.id = y.id where z.type = '6' order by z.sort"+
            " </script>")
    List<Map<String,String>> getTroopsTypeStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select z.name,ifnull(y.count,0) as count from p_dictionaries_value z left join(select count(*) as count,b.id,a.id as archives_id,b.name from jx_archives a left join p_dictionaries_value b on a.cader_type = b.id where b.type = '7' and a.status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and a.type = #{type}"+
            " </if>" +
            " group by b.id,b.name,a.id) y on z.id = y.id where z.type = '7' order by z.sort"+
            " </script>")
    List<Map<String,String>> getCadreTypeStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select count(*) as count,ifnull(longterm_insurance,'0') as name from jx_archives where status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and type = #{type}"+
            " </if>" +
            " group by (ifnull(longterm_insurance,'0'))"+
            " </script>")
    List<Map<String,String>> getLongTermInsuranceStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select count(*) as count,ifnull(family_doctor,'0') as name from jx_archives where status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and type = #{type}"+
            " </if>" +
            " group by (ifnull(family_doctor,'0'))"+
            " </script>")
    List<Map<String,String>> getFamilyDoctorStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select count(*) as count,ifnull(purchase_akt,'0') as name from jx_archives where status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and type = #{type}"+
            " </if>" +
            " group by (ifnull(purchase_akt,'0'))"+
            " </script>")
    List<Map<String,String>> getAktStatisticsData(@Param("type") String type);

    @Select("<script>"+
            " select count(*) as count,ifnull(purchase_jjga,'0') as name from jx_archives where status = '1'"+
            " <if test='type != null and type != &quot;&quot;'>"+
            " and type = #{type}"+
            " </if>" +
            " group by (ifnull(family_doctor,'0'))"+
            " </script>")
    List<Map<String,String>> getJjgaStatisticsData(@Param("type") String type);
}
