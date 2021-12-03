package com.ruoyi.fg.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.UtilException;
import com.ruoyi.fg.domain.FgExecl;
import com.ruoyi.fg.domain.FgFw;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author wyt
 */
@Slf4j
public class FgExcelUtil {

    /**
     * 对list数据源将其里面的数据导入到excel表单
     *
     * @return 结果
     */
    public AjaxResult exportExcel(FgExecl fgExecl)
    {
        OutputStream out = null;
        Workbook workbook = null;
        try
        {
            String path = FgExcelUtil.class.getResource("/excel/fg.xlsx").getPath();
            //String path = "C:\\Users\\Administrator\\Desktop\\房改\\模板\\fg.xlsx";

            log.info("模板 url = " + path);

            TemplateExportParams templateExportParams = new TemplateExportParams(path, true);

            //excel模板参数
            Map<String, Object> map = new HashMap<>();
            map.put("fcl", fgExecl);

            workbook = ExcelExportUtil.exportExcel(templateExportParams, map);

            Sheet sheet = workbook.getSheet("sheet2");

            List<FgFw> fgFwList = fgExecl.getFg().getFgFwList();
            if(fgFwList == null) {
                fgFwList = new ArrayList<>();
            }
            fgExecl.getFg().setFgFwList(fgFwList);

            int size = 1;
            if(fgFwList.size() > 0) {
                size = fgFwList.size();
            }

            sheet.addMergedRegion(new CellRangeAddress(8, 8 + 1 + size, 0, 0));

            String filename = encodingFilename("房改信息");
            out = new FileOutputStream(getAbsoluteFile(filename));
            workbook.write(out);
            return AjaxResult.success(filename);
        }
        catch (Exception e)
        {
            log.error("导出Excel异常{}", e.getMessage());
            throw new UtilException("导出Excel失败，请联系网站管理员！");
        }
        finally
        {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 编码文件名
     */
    public String encodingFilename(String filename)
    {
        filename = UUID.randomUUID() + "_" + filename + ".xlsx";
        return filename;
    }

    /**
     * 获取下载路径
     *
     * @param filename 文件名称
     */
    public String getAbsoluteFile(String filename)
    {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

}
