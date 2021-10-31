package com.courseman.egspringcourseman.controller;

import com.courseman.egspringcourseman.model.Course;
import com.courseman.egspringcourseman.model.Sclass;
import com.courseman.egspringcourseman.service.SclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SclassController {
    @Autowired
    SclassService service;
    @GetMapping("sclass")
    public String index(Model model){
        model.addAttribute("SUBJECT",service.findAll());
        return "sclass/index";
    }
    @GetMapping("sclass/add")
    public String addsclass(Model model){
        model.addAttribute("SUBJECT",new Sclass());
        return "sclass/addsclass";
    }
    @PostMapping("sclass/save")
    public String save(@Validated Sclass sclass, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/sclass";
        }
        service.save(sclass);
        redirectAttributes.addFlashAttribute("SUBJECT","Save a record successfully!");
        return "redirect:/sclass";
    }
    @GetMapping("sclass/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteById(id.intValue());
        redirectAttributes.addFlashAttribute("SUBJECT","Delete a record succsessfully!");
        return "redirect:/sclass";
    }

    @GetMapping("/sclass/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("SUBJECT", service.findById(id));
        return "sclass/editsclass";
    }
    @GetMapping("/sclass/search")
    public String search(Model model,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(name = "name",required = false)String s) {
        List<Sclass> list =null;
        if(StringUtils.hasText(s)){
            list=service.findByNamesclassContaining(s);
        }
        else {
            list=service.findAll();

        }
        model.addAttribute("SUBJECT", list);
        return "sclass/index";
    }
}
