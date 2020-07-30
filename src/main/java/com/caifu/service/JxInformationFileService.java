package com.caifu.service;

import com.caifu.pojo.JxInformationFile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 军休资料附件 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
public interface JxInformationFileService extends IService<JxInformationFile> {

    List<JxInformationFile> getInformationfileById(String informationId);
}
