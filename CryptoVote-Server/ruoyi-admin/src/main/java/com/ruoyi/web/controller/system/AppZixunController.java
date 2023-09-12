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
import com.ruoyi.system.domain.AppZixun;
import com.ruoyi.system.service.IAppZixunService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 咨询管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/system/zixun")
public class AppZixunController extends BaseController
{
    private String prefix = "system/zixun";

    @Autowired
    private IAppZixunService appZixunService;

    @RequiresPermissions("system:zixun:view")
    @GetMapping()
    public String zixun()
    {
        return prefix + "/zixun";
    }

    /**
     * 查询咨询管理列表
     */
    @RequiresPermissions("system:zixun:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppZixun appZixun)
    {
        startPage();
        List<AppZixun> list = appZixunService.selectAppZixunList(appZixun);
        return getDataTable(list);
    }

    /**
     * 导出咨询管理列表
     */
    @RequiresPermissions("system:zixun:export")
    @Log(title = "咨询管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppZixun appZixun)
    {
        List<AppZixun> list = appZixunService.selectAppZixunList(appZixun);
        ExcelUtil<AppZixun> util = new ExcelUtil<AppZixun>(AppZixun.class);
        return util.exportExcel(list, "咨询管理数据");
    }

    /**
     * 新增咨询管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存咨询管理
     */
    @RequiresPermissions("system:zixun:add")
    @Log(title = "咨询管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppZixun appZixun)
    {
        return toAjax(appZixunService.insertAppZixun(appZixun));
    }

    /**
     * 修改咨询管理
     */
    @RequiresPermissions("system:zixun:edit")
    @GetMapping("/edit/{zixunId}")
    public String edit(@PathVariable("zixunId") Long zixunId, ModelMap mmap)
    {
        AppZixun appZixun = appZixunService.selectAppZixunByZixunId(zixunId);
        mmap.put("appZixun", appZixun);
        return prefix + "/edit";
    }

    /**
     * 修改保存咨询管理
     */
    @RequiresPermissions("system:zixun:edit")
    @Log(title = "咨询管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppZixun appZixun)
    {
        return toAjax(appZixunService.updateAppZixun(appZixun));
    }

    /**
     * 删除咨询管理
     */
    @RequiresPermissions("system:zixun:remove")
    @Log(title = "咨询管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appZixunService.deleteAppZixunByZixunIds(ids));
    }
}
