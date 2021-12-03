package com.ruoyi.fg.service;

import java.util.List;
import com.ruoyi.fg.domain.Fg;

/**
 * 房改信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
public interface IFgService 
{
    /**
     * 查询房改信息管理
     * 
     * @param id 房改信息管理主键
     * @return 房改信息管理
     */
    Fg selectFgById(String id);

    /**
     * 查询房改信息管理列表
     * 
     * @param fg 房改信息管理
     * @return 房改信息管理集合
     */
    List<Fg> selectFgList(Fg fg);

    /**
     * 新增房改信息管理
     * 
     * @param fg 房改信息管理
     * @return 结果
     */
    int insertFg(Fg fg);

    /**
     * 修改房改信息管理
     * 
     * @param fg 房改信息管理
     * @return 结果
     */
    int updateFg(Fg fg);

    /**
     * 批量删除房改信息管理
     * 
     * @param ids 需要删除的房改信息管理主键集合
     * @return 结果
     */
    int deleteFgByIds(String ids);

    /**
     * 删除房改信息管理信息
     * 
     * @param id 房改信息管理主键
     * @return 结果
     */
    int deleteFgById(String id);
}
