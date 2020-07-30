package com.caifu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caifu.dto.JxActivityDto;
import com.caifu.pojo.JxActivity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 军休活动  Mapper 接口
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
public interface JxActivityMapper extends BaseMapper<JxActivity> {

    List<JxActivityDto> selectActivityList(Map<String, Object> map);
}
