package com.courseman.egspringcourseman.controller;

import com.courseman.egspringcourseman.model.Course;
import com.courseman.egspringcourseman.model.Sclass;
import com.courseman.egspringcourseman.model.Student;
import com.courseman.egspringcourseman.service.SclassService;
import com.courseman.egspringcourseman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    SclassService sclassService;
    @GetMapping("student")
    public String index(Model model){
        model.addAttribute("SUBJECT",service.findAll());
        return "student/index";
    }

    @GetMapping("student/add")
    public String addstudent(Model model, Model model1){
//       model1.addAttribute("SCLASS",sclassService.findAll());
        model.addAttribute("SUBJECT",new Student());
        return "student/addstudent";
    }
    @ModelAttribute(name = "SCLASS")
    public List<Sclass> getAllSclass(){
        return sclassService.findAll();
    }
    @PostMapping("student/save")
    public String save(@Validated Student student, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/student";
        }
        service.save(student);
        redirectAttributes.addFlashAttribute("SUBJECT","Save a record successfully!");
        return "redirect:/student";
    }
    @GetMapping("student/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteById(id.intValue());
        redirectAttributes.addFlashAttribute("SUBJECT","Delete a record succsessfully!");
        return "redirect:/student";
    }

    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("SUBJECT", service.findById(id));
        return "student/editstudent";
    }

    @GetMapping("/student/search")
    public String search(Model model,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(name = "name",required = false)String s) {
        List<Student> list =null;
        if(StringUtils.hasText(s)){
            list=service.findByNamestudentContaining(s);
        }
        else {
            list=service.findAll();

        }
        model.addAttribute("SUBJECT", list);
        return "student/index";
    }
}
