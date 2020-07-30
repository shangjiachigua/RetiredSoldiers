package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.mapper.JxPolicyMapper;
import com.caifu.pojo.JxPolicy;
import com.caifu.service.JxPolicyService;
import com.caifu.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-21
 */
@Service
public class JxPolicyServiceImpl extends ServiceImpl<JxPolicyMapper, JxPolicy> implements JxPolicyService {

    @Autowired
    private JxPolicyMapper jxPolicyMapper;

    @Override
    public IPage<JxPolicy> getPolicyList(String title, String currentPage, String pageSize) {
        QueryWrapper<JxPolicy> queryWrapper = new QueryWrapper<>();
        if (Utils.isNotNull(title)) {
            queryWrapper.like("title", title);
        }
        queryWrapper.eq("status", 1).orderByDesc("CREATE_TIME");
        Page<JxPolicy> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        IPage<JxPolicy> jxPolicyIPage = jxPolicyMapper.selectPage(page, queryWrapper);
        return jxPolicyIPage;
    }

    @Override
    public void add(String briefIntroduction, String content, String imgUrl, String title) {
        JxPolicy jxPolicy = new JxPolicy();
        jxPolicy.setBriefIntroduction(briefIntroduction);
        jxPolicy.setContent(content);
        jxPolicy.setStatus("1");
        jxPolicy.setCreateBy(1);
        jxPolicy.setCreateTime(new Date());
        jxPolicy.setUpdateTime(new Date());
        jxPolicy.setUpdateBy(1);
        jxPolicy.setTitle(title);
        jxPolicy.setImgUrl(imgUrl);
        jxPolicyMapper.insert(jxPolicy);
    }

    @Override
    public void updateById(Integer id, String briefIntroduction, String content, String imgUrl, String title) {
        JxPolicy jxPolicy = new JxPolicy();
        jxPolicy.setId(id);
        jxPolicy.setBriefIntroduction(briefIntroduction);
        jxPolicy.setContent(content);
        jxPolicy.setUpdateTime(new Date());
        jxPolicy.setTitle(title);
        jxPolicy.setImgUrl(imgUrl);
        jxPolicyMapper.updateById(jxPolicy);
    }

    @Override
    public void deleteById(String id) {
        JxPolicy jxPolicy = new JxPolicy();
        jxPolicy.setId(Integer.parseInt(id));
        jxPolicy.setStatus("9");
        jxPolicyMapper.updateById(jxPolicy);
    }

    @Override
    public JxPolicy getPolicyById(String id) {
        return jxPolicyMapper.selectById(id);
    }


}
