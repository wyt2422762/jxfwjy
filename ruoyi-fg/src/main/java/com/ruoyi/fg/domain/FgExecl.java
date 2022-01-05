package com.ruoyi.fg.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 房改信息导出实体类
 *
 * @author wyt
 */
@Data
public class FgExecl {
    private Fg fg;

    /**
     * 转让方式-买卖
     */
    private boolean zrfs_mm;

    /**
     * 转让方式-赠与(受遗赠)
     */
    private boolean zrfs_zy;

    /**
     * 转让方式-继承
     */
    private boolean zrfs_jc;

    /**
     * 转让方式-分割(合并)
     */
    private boolean zrfs_fb;

    /**
     * 转让方式-互换
     */
    private boolean zrfs_hh;

    /**
     * 转让方式-入股
     */
    private boolean zrfs_rg;

    /**
     * 转让方式-其他
     */
    private boolean zrfs_qt;

    /**
     * 转让方式-总和
     */
    private String zrfs_total;

    /**
     * 共同共有-转让方
     */
    private boolean gtgy_zrf;

    /**
     * 按份共有-转让方
     */
    private boolean afgy_zrf;

    /**
     * 共同共有-受让方
     */
    private boolean gtgy_srf;

    /**
     * 按份共有-受让方
     */
    private boolean afgy_srf;


    public boolean isZrfs_mm() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("买卖")) {
            zrfs_mm = true;
        }
        return zrfs_mm;
    }

    public boolean isZrfs_zy() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("赠与(受遗赠)")) {
            zrfs_zy = true;
        }
        return zrfs_zy;
    }

    public boolean isZrfs_jc() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("继承")) {
            zrfs_jc = true;
        }
        return zrfs_jc;
    }

    public boolean isZrfs_fb() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("分割(合并)")) {
            zrfs_fb = true;
        }
        return zrfs_fb;
    }

    public boolean isZrfs_hh() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("互换")) {
            zrfs_hh = true;
        }
        return zrfs_hh;
    }

    public boolean isZrfs_rg() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("以房屋出资入股")) {
            zrfs_rg = true;
        }
        return zrfs_rg;
    }

    public boolean isZrfs_qt() {
        String zrfs = fg.getZrfs();
        if (StringUtils.isNotBlank(zrfs) && zrfs.contains("其他法定情形")) {
            zrfs_qt = true;
        }
        return zrfs_qt;
    }

    public String getZrfs_total() {
        String zrfs = fg.getZrfs();
        String zrfsQt = fg.getZrfsQt();

        String res = "";
        if (StringUtils.isNotBlank(zrfs)) {
            res += zrfs.trim();
        }
        if (StringUtils.isNotBlank(zrfsQt)) {
            res += "," + zrfsQt.trim();
        }

        res.replace("其他法定情形", "");
        res.replace(",,", ",");

        zrfs_total = StringUtils.isNotBlank(res) ? res.trim() : null;

        return zrfs_total;
    }

    public boolean isGtgy_zrf() {
        String zrfGy = fg.getZrfGy();
        if(StringUtils.isNotBlank(zrfGy) && zrfGy.contains("共同共有")) {
            gtgy_zrf = true;
        }
        return gtgy_zrf;
    }

    public boolean isAfgy_zrf() {
        String zrfGy = fg.getZrfGy();
        if(StringUtils.isNotBlank(zrfGy) && zrfGy.contains("按份共有")) {
            afgy_zrf = true;
        }
        return afgy_zrf;
    }

    public boolean isGtgy_srf() {
        String srfGy = fg.getSrfGy();
        if(StringUtils.isNotBlank(srfGy) && srfGy.contains("共同共有")) {
            gtgy_srf = true;
        }
        return gtgy_srf;
    }

    public boolean isAfgy_srf() {
        String srfGy = fg.getSrfGy();
        if(StringUtils.isNotBlank(srfGy) && srfGy.contains("按份共有")) {
            afgy_srf = true;
        }
        return afgy_srf;
    }

    public FgExecl(Fg fg){
        this.fg = fg;
    }
}
