package cn.tsxygfy.restful_crud.controller;

import cn.tsxygfy.restful_crud.dao.DepartmentDao;
import cn.tsxygfy.restful_crud.dao.EmployeeDao;
import cn.tsxygfy.restful_crud.entities.Department;
import cn.tsxygfy.restful_crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 员工的增删改查controller
 * @version 1.0
 * @author 郭飞阳
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 员工列表页面
     * @param model model
     * @return string
     */
    @GetMapping("/emps")
    public String listAll(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     * @param model model
     * @return string
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * @param employee 员工
     * @return string
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id id
     * @return string
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * 来到修改员工页面，查出当前员工，回显
     * @param id 员工的id
     * @param model model
     * @return string
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/edit";
    }

    /**
     * 员工修改
     * @param employee 员工
     * @return string
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
