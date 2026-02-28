package io.github.ryonogawa.workclock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.ryonogawa.workclock.service.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping("/clock-in")
    public String clockInRegistration(@RequestParam long userId, Model model) {
        service.clockIn(userId);
        model.addAttribute("attendance_kind", "出勤");
        return "complete";
    }

}
