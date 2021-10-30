package com.courseman.egspringcourseman.controller;

import com.courseman.egspringcourseman.model.Course;
import com.courseman.egspringcourseman.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping("course")
    public String index(Model model){
        model.addAttribute("SUBJECT",service.findAll());
        return "course/index";
    }
    @GetMapping("course/add")
    public String addcourse(Model model){
        model.addAttribute("SUBJECT",new Course());
        return "course/addcourse";
    }
    @PostMapping("course/save")
    public String save(@Validated Course course, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/course";
        }
       service.save(course);
        redirectAttributes.addFlashAttribute("SUCCESS","Save a record successfully!");
        return "redirect:/course";
    }
    @GetMapping("course/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteById(id.intValue());
        redirectAttributes.addFlashAttribute("SUBJECT","Delete a record succsessfully!");
        return "redirect:/course";
    }

    @GetMapping("/course/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("SUBJECT", service.findById(id));
        return "course/editcourse";
    }
    @GetMapping(value = "/course/search",params = "searchid")
    public String search(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (!service.existsById(id)) {
            redirectAttributes.addFlashAttribute("SUBJECT","No ID in Database");
            return "redirect:/course";
        }
        model.addAttribute("SUBJECT", service.findById(id));
        return "course/index";
    }
}
