package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.dto.JxJournalismDto;
import com.caifu.mapper.JxJournalismMapper;
import com.caifu.pojo.JxJournalism;
import com.caifu.service.JxJournalismService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻信息表 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-22
 */
@Service
public class JxJournalismServiceImpl extends ServiceImpl<JxJournalismMapper, JxJournalism> implements JxJournalismService {
    @Autowired
    private JxJournalismMapper jxJournalismMapper;


    @Override
    public PageInfo<JxJournalismDto> getNewsList(String title, String isTop, String currentPage, String pageSize) {
        Map<String, Object> params = new HashMap<>(10);
        params.put("title", title);
        params.put("isTop", isTop);
        PageHelper.startPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        List<JxJournalismDto> jxJournalismDtos = jxJournalismMapper.selectJxJournalismList(params);
        return new PageInfo<>(jxJournalismDtos);
    }

    @Override
    public void deleteById(String id) {
        JxJournalism jxJournalism = new JxJournalism();
        jxJournalism.setId(Integer.parseInt(id));
        jxJournalism.setStatus("9");
        jxJournalismMapper.updateById(jxJournalism);
    }

    @Override
    public JxJournalism getPolicyById(String id) {
        return jxJournalismMapper.selectById(id);
    }

    @Override
    public Integer countGrass() {
        QueryWrapper<JxJournalism> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_top", 1);
        return jxJournalismMapper.selectCount(queryWrapper);
    }

    @Override
    public void grassOrCancel(String id, String isTop) {
        JxJournalism jxJournalism = new JxJournalism();
        jxJournalism.setId(Integer.parseInt(id));
        //0 不置顶 1置顶
        String noTop = "0";
        String isTop2 = "1";
        if (noTop.equals(isTop)) {
            jxJournalism.setIsTop("1");
        } else if (isTop2.equals(isTop)) {
            jxJournalism.setIsTop("0");
        }
        jxJournalismMapper.updateById(jxJournalism);
    }

    @Override
    public void updateById(Integer id, String briefIntroduction, String content, String imgUrl, String title) {
        JxJournalism jxJournalism = new JxJournalism();
        jxJournalism.setId(id);
        jxJournalism.setBriefIntroduction(briefIntroduction);
        jxJournalism.setContent(content);
        jxJournalism.setImgUrl(imgUrl);
        jxJournalism.setUpdateTime(new Date());
        jxJournalism.setTitle(title);
        jxJournalismMapper.updateById(jxJournalism);
    }

    @Override
    public void add(String briefIntroduction, String content, String imgUrl, String title) {
        JxJournalism jxJournalism = new JxJournalism();
        jxJournalism.setIsTop("0");
        jxJournalism.setStatus("1");
        jxJournalism.setBriefIntroduction(briefIntroduction);
        jxJournalism.setBrowseNumber(0);
        jxJournalism.setContent(content);
        jxJournalism.setCreateBy(1);
        jxJournalism.setCreateTime(new Date());
        jxJournalism.setImgUrl(imgUrl);
        jxJournalism.setTitle(title);
        jxJournalism.setUpdateTime(new Date());
        jxJournalism.setUpdateBy(1);
        jxJournalism.setTopImgUrl("1");
        jxJournalism.setType("1");
        jxJournalism.setUrl("1");
        jxJournalismMapper.insert(jxJournalism);
    }
}
