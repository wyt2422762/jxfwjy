package com.ruoyi.zfjl.mapper;

import com.ruoyi.zfjl.domain.Zfjl;
import com.ruoyi.zfjl.domain.ZfjlFj;

import java.util.List;

/**
 * 执法记录主Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-07
 */
public interface ZfjlMapper
{
    /**
     * 查询执法记录
     * 
     * @param id 执法记录主键
     * @return 执法记录
     */
    Zfjl selectZfjlById(String id);

    /**
     * 查询执法记录列表
     * 
     * @param zfjl 执法记录
     * @return 执法记录集合
     */
    List<Zfjl> selectZfjlList(Zfjl zfjl);

    /**
     * 新增执法记录
     * 
     * @param zfjl 执法记录
     * @return 结果
     */
    int insertZfjl(Zfjl zfjl);

    /**
     * 修改执法记录
     * 
     * @param zfjl 执法记录
     * @return 结果
     */
    int updateZfjl(Zfjl zfjl);

    /**
     * 删除执法记录
     * 
     * @param id 执法记录主键
     * @return 结果
     */
    int deleteZfjlById(String id);

    /**
     * 批量删除执法记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteZfjlByIds(String[] ids);

    ///////////////////////////////////////////////////////////////////

    /**
     * 批量删除执法记录-文书
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteZfjlFjByFkZfjlids(String[] ids);

    /**
     * 通过执法记录主键删除执法记录-文书信息
     * 
     * @param id 执法记录ID
     * @return 结果
     */
    int deleteZfjlFjByFkZfjlid(String id);

    /**
     * 批量新增执法记录-文书
     *
     * @param zfjlWsList 执法记录-文书列表
     * @return 结果
     */
    int batchZfjlFj(List<ZfjlFj> zfjlFjList);

}
