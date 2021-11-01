package com.courseman.egspringcourseman.controller;

import com.courseman.egspringcourseman.model.Course;
import com.courseman.egspringcourseman.model.Erolment;
import com.courseman.egspringcourseman.model.Student;
import com.courseman.egspringcourseman.service.CourseService;
import com.courseman.egspringcourseman.service.EnrolmentService;
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
public class EnrolmentController {
    @Autowired
    EnrolmentService service;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @GetMapping("enrolment")
    public String index(Model model){
        model.addAttribute("SUBJECT",service.findAll());
        return "enrolment/index";
    }

    @GetMapping("enrolment/add")
    public String addenrolment(Model model, Model model1){
//       model1.addAttribute("SCLASS",sclassService.findAll());
        model.addAttribute("SUBJECT",new Erolment());
        return "enrolment/addenrolment";
    }
    @ModelAttribute(name = "COURSE")
    public List<Course> getAllCourse(){
        return courseService.findAll();
    }
    @ModelAttribute(name = "STUDENT")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }
    @PostMapping("enrolment/save")
    public String save(@Validated Erolment erolment, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/enrolment";
        }
        service.save(erolment);
        redirectAttributes.addFlashAttribute("SUBJECT","Save a record successfully!");
        return "redirect:/enrolment";
    }
    @GetMapping("enrolment/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteById(id.intValue());
        redirectAttributes.addFlashAttribute("SUBJECT","Delete a record succsessfully!");
        return "redirect:/enrolment";
    }

    @GetMapping("/enrolment/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("SUBJECT", service.findById(id));
        return "enrolment/editenrolment";
    }
    @GetMapping("/enrolment/search")
    public String search(Model model){

//                         @RequestParam(name = "name",required = false)String s) {
        List<Erolment> list =null;
//        if(StringUtils.hasText(s)){
//            list=service.findErolmentByIdstudentContaining(s);
//            list=service.findErolmentByIdstudent(s);
//            list =service.findByIdstudentLike(s);
//        }
//        else {
            list=service.findAll();

//        }
        model.addAttribute("SUBJECT", list);
        return "enrolment/index";
    }

}
