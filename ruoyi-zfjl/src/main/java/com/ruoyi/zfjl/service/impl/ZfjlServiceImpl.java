package com.ruoyi.zfjl.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zfjl.domain.Zfjl;
import com.ruoyi.zfjl.domain.ZfjlFj;
import com.ruoyi.zfjl.mapper.ZfjlMapper;
import com.ruoyi.zfjl.service.IZfjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.core.text.Convert;

/**
 * 执法记录主Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-07
 */
@Service
public class ZfjlServiceImpl implements IZfjlService {
    @Autowired
    private ZfjlMapper zfjlMapper;

    /**
     * 查询执法记录
     *
     * @param id 执法记录主键
     * @return 执法记录
     */
    @Override
    public Zfjl selectZfjlById(String id) {
        return zfjlMapper.selectZfjlById(id);
    }

    /**
     * 查询执法记录列表
     *
     * @param zfjl 执法记录
     * @return 执法记录
     */
    @Override
    public List<Zfjl> selectZfjlList(Zfjl zfjl) {
        return zfjlMapper.selectZfjlList(zfjl);
    }

    /**
     * 新增执法记录
     *
     * @param zfjl 执法记录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertZfjl(Zfjl zfjl) {
        zfjl.setCreateTime(DateUtils.getNowDate());
        int rows = zfjlMapper.insertZfjl(zfjl);
        insertZfjlFj(zfjl);
        return rows;
    }

    /**
     * 修改执法记录
     *
     * @param zfjl 执法记录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateZfjl(Zfjl zfjl) {
        zfjl.setUpdateTime(DateUtils.getNowDate());
        //删除附件
        zfjlMapper.deleteZfjlFjByFkZfjlid(zfjl.getId());
        //插入附件
        insertZfjlFj(zfjl);
        return zfjlMapper.updateZfjl(zfjl);
    }

    /**
     * 批量删除执法记录
     *
     * @param ids 需要删除的执法记录主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteZfjlByIds(String ids) {
        zfjlMapper.deleteZfjlFjByFkZfjlids(Convert.toStrArray(ids));
        return zfjlMapper.deleteZfjlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执法记录主信息
     *
     * @param id 执法记录主主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteZfjlById(String id) {
        zfjlMapper.deleteZfjlFjByFkZfjlid(id);
        return zfjlMapper.deleteZfjlById(id);
    }

    /**
     * 新增执法记录-附件信息
     *
     * @param zfjl 执法记录
     */
    public void insertZfjlFj(Zfjl zfjl) {
        List<ZfjlFj> fjList = zfjl.getFjList();
        if (StringUtils.isNotNull(fjList)) {
            List<ZfjlFj> list = new ArrayList<>();
            for (ZfjlFj zfjlFj : fjList) {
                zfjlFj.setFkZfjlid(zfjl.getId());
                list.add(zfjlFj);
            }
            if (list.size() > 0) {
                zfjlMapper.batchZfjlFj(list);
            }
        }
    }
}
