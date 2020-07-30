package com.caifu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caifu.pojo.PDictionariesValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PDictionariesValueMapper extends BaseMapper<PDictionariesValue> {

    /**
     * 功能描述: 根据科目获取最大的id
     *
     * @auther: Lyf
     * @date: 2020/7/20 16:03
     * @param:
     * @return:
     */
    @Select("select max(cast(id as signed integer)) from p_dictionaries_value where type = #{type}")
    String getMaxIdByType(String type)throws Exception;

    /**
     * 功能描述: 根据科目获取最大的排序号
     *
     * @auther: Lyf
     * @date: 2020/7/20 16:03
     * @param:
     * @return:
     */
    @Select("select max(sort) from p_dictionaries_value where type = #{type}")
    Integer getMaxSortByType(String type)throws Exception;
}