package by.svyat.base.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/employees_info")
    public String getInfoForAllEmployees() {
        return "view_for_all_employees";
    }

    @GetMapping("/hr_info")
    public String getInfoForAllHRs() {
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoForAllManagers() {
        return "view_for_managers";
    }
}
