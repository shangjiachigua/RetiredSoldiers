package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.pojo.PDictionariesType;
import com.caifu.pojo.PDictionariesValue;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lyf
 * @Date: 2020/7/16 10:24
 * @Description:
 */
public interface DataService {

    /**
     * 功能描述: 获取字典科目
     *
     * @auther: 田稳稳
     * @date: 2020/7/16 10:25
     * @param:
     * @return:
     */
    List<PDictionariesType> getPDictionariesTypeList();

    /**
     * 功能描述:添加字典
     *
     * @auther: 田稳稳
     * @date: 2020/7/16 10:26
     * @param:
     * @return:
     */
    Map<String, Object> addPDictionariesValue(String name, String type) throws ParseException;

    /**
     *
     * 功能描述: 根据Id删除字典
     *
     * @param: [id]
     * @return: void
     * @auther: tian
     * @date: 2020/7/16 10:32
     */
    void deletePDictionariesValue(String id);

    /**
     *
     * 功能描述: 根据类型获取字典列表
     *
     * @param: [type, currentPage, pageSize]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.caifu.pojo.PDictionariesValue>
     * @auther: tian
     * @date: 2020/7/16 10:32
     */
    IPage<PDictionariesValue> getPDictionariesValueByType(String type, String currentPage, String pageSize);

    /**
     *
     * 功能描述: 根据类型获取字典列表
     *
     * @param: [type, currentPage, pageSize]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.caifu.pojo.PDictionariesValue>
     * @auther: tian
     * @date: 2020/7/16 10:32
     */
    List<PDictionariesValue> getPDictionariesValueByType(String type);

    /**
     *
     * 功能描述: 根据id和type更新字典
     *
     * @param: [name, type, id]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: tian
     * @date: 2020/7/16 10:33
     */
    Map<String, Object> updatePDictionariesValue(String name, String type, String id);
}
