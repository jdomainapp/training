package com.courseman.egspringcourseman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CoursemanController {
    @GetMapping("/")
    public String homepage(HttpServletRequest request){
        request.setAttribute("HI","Website Course Man");
        return "index";
    }

}
