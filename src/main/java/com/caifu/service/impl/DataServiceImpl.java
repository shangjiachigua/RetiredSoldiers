package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.mapper.PDictionariesTypeMapper;
import com.caifu.mapper.PDictionariesValueMapper;
import com.caifu.pojo.PDictionariesType;
import com.caifu.pojo.PDictionariesValue;
import com.caifu.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName DataService.java
 * @createTime 2020年07月15日 14:38
 **/
@Service
public class DataServiceImpl extends ServiceImpl<PDictionariesValueMapper, PDictionariesValue> implements DataService {
    @Autowired
    private PDictionariesTypeMapper pDictionariesTypeMapper;

    @Autowired
    private PDictionariesValueMapper pDictionariesValueMapper;


    @Override
    @Transactional
    public List<PDictionariesType> getPDictionariesTypeList() {
        QueryWrapper<PDictionariesType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<PDictionariesType> pDictionariesTypes = pDictionariesTypeMapper.selectList(queryWrapper);
        return pDictionariesTypes;
    }

    @Override
    @Transactional
    public Map<String, Object> addPDictionariesValue(String name, String type) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        try {
            //校验当前分类下是否存在
            QueryWrapper<PDictionariesValue> wrapper = new QueryWrapper<>();
            wrapper.eq("name", name).eq("type", type).eq("status", "1");
            int count = pDictionariesValueMapper.selectCount(wrapper);
            if (count == 0) {
                String maxId = pDictionariesValueMapper.getMaxIdByType(type);
                String id = "";
                if (StringUtils.isBlank(maxId)) {
                    maxId = "1";
                    id = type;
                    int len = type.length() + maxId.length();
                    if (len <= 10) {
                        for (int i = 0; i < 10 - len; i++) {
                            id += "0";
                        }
                    }
                    id += maxId;
                } else {
                    id = (Long.parseLong(maxId) + 1) + "";
                }
                //获取排序字段最大值
                //QueryWrapper<PDictionariesValue> queryWrapper = new QueryWrapper<>();
                //queryWrapper.eq("type", type).orderByDesc("sort");
                Integer sort = pDictionariesValueMapper.getMaxSortByType(type);
                //List<PDictionariesValue> pDictionariesValues = pDictionariesValueMapper.selectList(queryWrapper);
                PDictionariesValue value = new PDictionariesValue();
                value.setCreateBy(1);
                value.setCreateTime(new Date());
                value.setName(name);
                value.setStatus("1");
                value.setUpdateBy(1);
                value.setType(type);
                value.setId(id);
                value.setUpdateTime(new Date());
                if (sort != null && sort > 0) {
                    value.setSort(sort + 1);
                } else {
                    value.setSort(1);
                }
                pDictionariesValueMapper.insert(value);
                map.put("msg", "保存成功");
            } else {
                map.put("msg", "名称不允许重复");
            }
        } catch (Exception e) {
            map.put("msg", "系统异常，保存失败！");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    @Transactional
    public void deletePDictionariesValue(String id) {
        PDictionariesValue value = new PDictionariesValue();
        value.setId(id);
        value.setStatus("9");
        pDictionariesValueMapper.updateById(value);
    }

    @Override
    @Transactional
    public IPage<PDictionariesValue> getPDictionariesValueByType(String type, String currentPage, String pageSize) {
        QueryWrapper<PDictionariesValue> wrapper = new QueryWrapper<>();
        wrapper.eq("type", type).eq("STATUS", '1').orderByAsc("sort");
        Page<PDictionariesValue> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        IPage<PDictionariesValue> pDictionariesValueIPage = pDictionariesValueMapper.selectPage(page, wrapper);
        return pDictionariesValueIPage;
    }

    @Override
    public List<PDictionariesValue> getPDictionariesValueByType(String type) {
        QueryWrapper<PDictionariesValue> wrapper = new QueryWrapper<>();
        wrapper.eq("type", type).eq("status", '1').orderByAsc("sort");
        return pDictionariesValueMapper.selectList(wrapper);
    }

    @Override
    @Transactional
    public Map<String, Object> updatePDictionariesValue(String name, String type, String id) {
        Map<String, Object> map = new HashMap<>();
        //校验当前分类下是否存在
        QueryWrapper<PDictionariesValue> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name).eq("type", type);
        int count = pDictionariesValueMapper.selectCount(wrapper);
        if (count == 0) {
            PDictionariesValue value = new PDictionariesValue();
            value.setId(id);
            value.setName(name);
            value.setUpdateTime(new Date());
            pDictionariesValueMapper.updateById(value);
            map.put("msg", "保存成功");
        } else {
            map.put("msg", "名称不允许重复");
        }
        return map;
    }
}
