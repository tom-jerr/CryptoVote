package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AppShenhe;
import com.ruoyi.system.service.IAppShenheService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报名审核Controller
 * 
 * @author chris
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/system/shenhe")
public class AppShenheController extends BaseController
{
    private String prefix = "system/shenhe";

    @Autowired
    private IAppShenheService appShenheService;

    @RequiresPermissions("system:shenhe:view")
    @GetMapping()
    public String shenhe()
    {
        return prefix + "/shenhe";
    }

    /**
     * 查询报名审核列表
     */
    @RequiresPermissions("system:shenhe:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppShenhe appShenhe)
    {
        startPage();
        List<AppShenhe> list = appShenheService.selectAppShenheList(appShenhe);
        return getDataTable(list);
    }

    /**
     * 导出报名审核列表
     */
    @RequiresPermissions("system:shenhe:export")
    @Log(title = "报名审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppShenhe appShenhe)
    {
        List<AppShenhe> list = appShenheService.selectAppShenheList(appShenhe);
        ExcelUtil<AppShenhe> util = new ExcelUtil<AppShenhe>(AppShenhe.class);
        return util.exportExcel(list, "报名审核数据");
    }

    /**
     * 新增报名审核
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报名审核
     */
    @RequiresPermissions("system:shenhe:add")
    @Log(title = "报名审核", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppShenhe appShenhe)
    {
        return toAjax(appShenheService.insertAppShenhe(appShenhe));
    }

    /**
     * 修改报名审核
     */
    @RequiresPermissions("system:shenhe:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AppShenhe appShenhe = appShenheService.selectAppShenheById(id);
        mmap.put("appShenhe", appShenhe);
        return prefix + "/edit";
    }

    /**
     * 修改保存报名审核
     */
    @RequiresPermissions("system:shenhe:edit")
    @Log(title = "报名审核", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppShenhe appShenhe)
    {
        return toAjax(appShenheService.updateAppShenhe(appShenhe));
    }

    /**
     * 删除报名审核
     */
    @RequiresPermissions("system:shenhe:remove")
    @Log(title = "报名审核", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appShenheService.deleteAppShenheByIds(ids));
    }
}
