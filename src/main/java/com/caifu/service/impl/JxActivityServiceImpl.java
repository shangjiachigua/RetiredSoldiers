package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.dto.JxActivityDto;
import com.caifu.mapper.JxActivityMapper;
import com.caifu.mapper.JxActivityMenberMapper;
import com.caifu.mapper.JxActivityRoomMapper;
import com.caifu.pojo.JxActivity;
import com.caifu.pojo.JxActivityMenber;
import com.caifu.pojo.JxActivityRoom;
import com.caifu.service.JxActivityService;
import com.caifu.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 军休活动  服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
@Service
public class JxActivityServiceImpl extends ServiceImpl<JxActivityMapper, JxActivity> implements JxActivityService {

    @Autowired
    private JxActivityMapper jxActivityMapper;

    @Autowired
    private JxActivityRoomMapper jxActivityRoomMapper;

    @Autowired
    private JxActivityMenberMapper jxActivityMenberMapper;

    @Override
    public PageInfo<JxActivityDto> getActivityList(String title, String currentPage, String pageSize, String status) {
        Map<String, Object> params = new HashMap<>(5);
        String flag = "8";
        if (flag.equals(status)) {
            params.put("currentTimeOut", "NOW()");
        } else {
            params.put("status", status);
        }
        params.put("title", title);
        PageHelper.startPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        List<JxActivityDto> jxActivityDtos = jxActivityMapper.selectActivityList(params);
        return new PageInfo<>(jxActivityDtos);
    }

    @Override
    public void cancelPublish(String id) {
        JxActivity activity = new JxActivity();
        activity.setId(Integer.parseInt(id));
        activity.setStatus("0");
        jxActivityMapper.updateById(activity);
    }

    @Override
    public void publish(String id) {
        JxActivity activity = new JxActivity();
        activity.setId(Integer.parseInt(id));
        activity.setStatus("1");
        jxActivityMapper.updateById(activity);
    }

    @Override
    public void deleteById(String id) {
        JxActivity activity = new JxActivity();
        activity.setId(Integer.parseInt(id));
        activity.setStatus("9");
        jxActivityMapper.updateById(activity);
    }


    @Override
    public JxActivityDto getActivityInfoById(String id) {
        //TODO
        JxActivityDto jxActivityDto = new JxActivityDto();
        JxActivity activity = jxActivityMapper.selectById(id);
        JxActivityRoom jxActivityRoom = jxActivityRoomMapper.selectById(activity.getRoomNo());
        return jxActivityDto;
    }

    @Override
    public IPage<JxActivityMenber> getPersonInfoByActivityId(String name, String activityId, String currentPage, String pageSize) {
        QueryWrapper<JxActivityMenber> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ACTIVITY_ID", activityId).eq("status", 1);
        if (Utils.isNotNull(name)) {
            queryWrapper.like("name", name);
        }
        Page<JxActivityMenber> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        return jxActivityMenberMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<JxActivityMenber> getExportExcelList(String activityId) {
        QueryWrapper<JxActivityMenber> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ACTIVITY_ID", activityId).eq("status", 1);
        return jxActivityMenberMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<JxActivityRoom> getActivityRoom(String currentPage, String pageSize) {
        QueryWrapper<JxActivityRoom> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        Page<JxActivityRoom> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        return jxActivityRoomMapper.selectPage(page, queryWrapper);
    }

    @Override
    public JxActivityRoom getActivityRoomById(String id) {
        return jxActivityRoomMapper.selectById(id);
    }

    @Override
    public void add(JxActivity activity) {
        JxActivity insert = new JxActivity();
        insert.setStatus("0");
        insert.setAccompanying(activity.getAccompanying());
        insert.setActivityDescribe(activity.getActivityDescribe());
        insert.setActivityEndTime(activity.getActivityEndTime());
        insert.setActivityStartTime(activity.getActivityStartTime());
        insert.setAddress(activity.getAddress());
        insert.setContactInformation(activity.getContactInformation());
        insert.setCreateBy(1);
        insert.setCreateTime(new Date());
        insert.setDetails(activity.getDetails());
        insert.setImgUrl(activity.getImgUrl());
        insert.setRecruitsEndTime(activity.getRecruitsEndTime());
        insert.setRecruitsStartTime(activity.getRecruitsStartTime());
        insert.setRecruitsNumber(activity.getRecruitsNumber());
        insert.setRoomNo(activity.getRoomNo());
        insert.setTitle(activity.getTitle());
        insert.setUpdateBy(1);
        insert.setUpdateTime(new Date());
        jxActivityMapper.insert(insert);
    }

    @Override
    public void updateActivityById(JxActivity activity) {
        JxActivity updateActivity = new JxActivity();
        BeanUtils.copyProperties(activity, updateActivity);
        jxActivityMapper.updateById(updateActivity);
    }

    @Override
    public JxActivity getActivityById(String id) {
        QueryWrapper<JxActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return jxActivityMapper.selectOne(queryWrapper);
    }

    @Override
    public List<JxActivityRoom> getActivityRoomList() {
        QueryWrapper<JxActivityRoom> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        return jxActivityRoomMapper.selectList(queryWrapper);
    }

}
