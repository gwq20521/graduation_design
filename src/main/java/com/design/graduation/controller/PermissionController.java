/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * E-mail:gwq20521@163.com
 * copyright: 2018
 */
package com.design.graduation.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.design.graduation.model.DeptPerm;
import com.design.graduation.model.Employee;
import com.design.graduation.model.Permission;
import com.design.graduation.model.XtreeData;
import com.design.graduation.service.DeptPermService;
import com.design.graduation.service.PermissionService;
import com.design.graduation.util.JqGridJsonBean;
import com.design.graduation.util.ReturnData;
import com.google.gson.Gson;

/**
 * <p>控制层</p>
 * <p>Table: permission - </p>
 * permission insert 增加数据,
 * permission delete 删除数据,
 * permission update 修改数据,
 * permission select 查询数据,
 * permission export 导出数据,
 * permission import 导入数据
 * @since ${.now}
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private PermissionService permissionService;

    @Resource
    private DeptPermService deptPermService;

    /**
     * 数据展示页面
     * @return
     */
    //@RequiresPermissions(value = "permission_show")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model, HttpServletRequest request) {
        return "permission/show";
    }

    /**
     * 数据新增页面
     * @return
     */
    //@RequiresPermissions(value = "permission_add")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        return "permission/add";
    }

    /**
     * 数据修改页面
     * @return
     */
    //@RequiresPermissions(value = "permission_edit")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        Permission permission = new Permission();
        permission.setId(Integer.valueOf(Integer.parseInt(id)));

        ReturnData rd = permissionService.selectByParam(null, permission);
        if (rd.getCode().equals("OK")) {
            List<Permission> data = (List<Permission>) rd.getData().get("data");

            model.addAttribute("olddata", JSON.toJSONString(data.get(0)));
        }
        return "permission/edit";
    }

    /**
     * 对 permission 的数据插入操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ReturnData insert(@RequestBody Permission permission, Model model, HttpServletRequest request) {
        Employee currentEmp = ((Employee) request.getSession().getAttribute("current_emp"));

        return permissionService.insert(permission);//执行插入 Permission 操作
    }

    /**
     * 对 permission 的数据删除操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ReturnData delete(@RequestBody Permission permission, Model model, HttpServletRequest request) {
        return permissionService.delete(permission);//执行删除 Permission  操作
    }

    /**
     * 对 permission 的数据批量删除操作
     * @param request 请求数据
     */
    @RequestMapping({ "/deleteBatch" })
    @ResponseBody
    public ReturnData deleteBatch(HttpServletRequest request) {
        ReturnData rd = new ReturnData();
        String ids = request.getParameter("ids");
        if ((ids == null) || ("".equals(ids))) {
            rd.setCode("ERROR");
            rd.setMsg("ids为空");
        }
        else {
            rd = permissionService.deleteBatch(ids.split(","));
        }
        return rd;
    }

    /**
     * 对 permission 的数据修改操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ReturnData update(@RequestBody Permission permission, Model model, HttpServletRequest request) {
        Employee currentEmp = ((Employee) request.getSession().getAttribute("current_emp"));

        return permissionService.update(permission);//执行 Permission  操作
    }

    /**
     * 对 permission 的数据分页查询操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public JqGridJsonBean select(String GridParam, Model model, HttpServletRequest request) {
        Permission permission = new Gson().fromJson(GridParam, Permission.class);//json 转对象

        String page = request.getParameter("page");//第几页
        String rows = request.getParameter("rows");//一页有几行
        String order_by = request.getParameter("order_by");//排序

        //分页查询
        return permissionService.select(page, rows, order_by, permission);
    }

    /**
     * 对 permission 的数据分页查询操作 - 关联查询
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/selectRelationData", method = RequestMethod.POST)
    @ResponseBody
    public JqGridJsonBean selectRelationData(String GridParam, Model model, HttpServletRequest request) {
        Permission permission = new Gson().fromJson(GridParam, Permission.class);//json 转对象

        String page = request.getParameter("page");//第几页
        String rows = request.getParameter("rows");//一页有几行
        String order_by = request.getParameter("order_by");//排序

        //分页查询
        return permissionService.selectRelationData(page, rows, order_by, permission);
    }

    /**
     * 对 permission 的数据查询操作不分页
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/selectByParam", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ReturnData selectByParam(@RequestBody Permission permission, Model model, HttpServletRequest request) {
        String order_by = request.getParameter("order_by");//排序

        return permissionService.selectByParam(order_by, permission);
    }

    /**
     * 对 permission 的数据导出操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) {
        //1、使用JSONObject
        String json = request.getParameter("json");
        Permission permission = new Gson().fromJson(json, Permission.class);

        String page = request.getParameter("page");//第几页
        String rows = request.getParameter("rows");//一页有几行
        String order_by = request.getParameter("order_by");//排序
        //分页查询
        JqGridJsonBean rd = permissionService.select(page, rows, order_by, permission);

        //创建HSSFWorkbook对象(excel的文档对象)  
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）  
        HSSFSheet sheet = wb.createSheet("permission");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
        HSSFRow row1 = sheet.createRow(0);

        //创建单元格并设置单元格内容  
        row1.createCell(1 - 1).setCellValue("主键");
        row1.createCell(2 - 1).setCellValue("权限名称");
        row1.createCell(3 - 1).setCellValue("所属类别-1-菜单 2-权限");
        row1.createCell(4 - 1).setCellValue("权限编码");
        row1.createCell(5 - 1).setCellValue("被访问的链接");
        row1.createCell(6 - 1).setCellValue("所属的上级菜单ID");
        row1.createCell(7 - 1).setCellValue("是否可用 - 0-不可用 1-可用");
        //在sheet里创建第三行  
        @SuppressWarnings("unchecked")
        List<Permission> maps = (List<Permission>) rd.getRoot();
        for (int i = 0; i < maps.size(); i++) {
            Permission map = maps.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(1 - 1).setCellValue(map.getId() + "");
            row.createCell(2 - 1).setCellValue(map.getName() + "");
            row.createCell(3 - 1).setCellValue(map.getType() + "");
            row.createCell(4 - 1).setCellValue(map.getPercode() + "");
            row.createCell(5 - 1).setCellValue(map.getUrl() + "");
            row.createCell(6 - 1).setCellValue(map.getParentId() + "");
            row.createCell(7 - 1).setCellValue(map.getAvailable() + "");
        }

        //输出Excel文件  
        try {
            ServletOutputStream output = response.getOutputStream();
            String fileName = new String(("导出permission").getBytes(), "ISO8859_1");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            response.setContentType("application/binary;charset=utf-8");
            wb.write(output);
            output.flush();
            output.close();

        }
        catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 对 permission 的数据导入操作
     * @param permission json 数据对象
     * @param model spring model 操作
     * @param request 请求数据
     * @return ReturnData 通用数据对象
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public ReturnData _import(@RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletResponse response) {
        ReturnData rd = new ReturnData();
        String filename = file.getOriginalFilename();
        if (filename == null || "".equals(filename)) {
            return null;
        }
        try {
            InputStream XSSFinput = file.getInputStream();
            InputStream HSSFinput = file.getInputStream();
            Workbook workBook = null;
            try {
                workBook = new XSSFWorkbook(XSSFinput);
            }
            catch (Exception ex) {
                workBook = new HSSFWorkbook(HSSFinput);
            }

            Sheet sheet = workBook.getSheetAt(0);
            if (sheet != null) {
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    Row row = sheet.getRow(i);
                    Permission permission = new Permission();
                    //System.out.println(row.getCell(0));
                    //此处自己添字段例如 myTable.set...(row.getCell(0))

                    //permissionService.insert(permission);  
                }

            }
        }
        catch (Exception e) {
            rd.setCode("ERROR");
            rd.setMsg(e.getMessage());
            //e.printStackTrace();  
        }

        rd.setCode("OK");
        rd.setMsg("数据导入成功");
        return rd;
    }

    @RequestMapping({ "/ajaxSelectPermListByUse" })
    @ResponseBody
    public ReturnData ajaxSelectMaxEmpCode(HttpServletRequest request) {
        return permissionService.ajaxSelectPermListByUse();
    }

    /**
     * 得到指定角色权限树
     * @param roleId
     * @param roleName
     * @return
     */
    @RequestMapping("/xtreedata")
    @ResponseBody
    /*public JSONArray xtreeData() {
        List<XtreeData> xtreeDataList = permissionService.selXtreeData();
        JSONArray xtreeDataArray = JSONArray.parseArray(JSON.toJSONString(xtreeDataList));
        return xtreeDataArray;
    }*/
    public List<XtreeData> xtreeData() {
        return permissionService.selXtreeData();
    }
    /*public String xtreeData() {
        List<XtreeData> xtreeDataList = permissionService.selXtreeData();
        String xtreeDataStr = JSON.toJSONString(xtreeDataList);
        System.out.println(xtreeDataStr);
        try {
            System.out.println(new String(xtreeDataStr.getBytes(), "UTF-8"));
            System.out.println(new String(xtreeDataStr.getBytes(), "ISO8859-1"));
            System.out.println(new String(xtreeDataStr.getBytes(), "GBK"));
            System.out.println(new String(xtreeDataStr.getBytes(), "GB2312"));
            return new String(xtreeDataStr.getBytes(), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return xtreeDataStr;
    }*/

    /**
     * 得到指定角色权限树
     * @param roleId
     * @param roleName
     * @return
     */
    @RequestMapping("/ajaxSelectPermListByUseXtreeData")
    @ResponseBody
    public List<XtreeData> ajaxSelectPermListByUseXtreeData(HttpServletRequest request) {
        String deptId = request.getParameter("deptId");
        int deptIdI = Integer.valueOf(deptId);

        //获取权限信息
        DeptPerm deptPerm = new DeptPerm();
        deptPerm.setDeptId(deptIdI);

        List<Integer> permValue = new ArrayList<Integer>();
        ReturnData rdDeptPerm = deptPermService.selectByParam(null, deptPerm);
        List<DeptPerm> dataDeptPerm = (List<DeptPerm>) rdDeptPerm.getData().get("data");
        if (dataDeptPerm.size() > 0) {
            for (int i = 0; i < dataDeptPerm.size(); i++) {
                permValue.add(dataDeptPerm.get(i).getPermId());
            }
        }

        return permissionService.selXtreeData(permValue);
    }

}