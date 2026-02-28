package io.github.ryonogawa.workclock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.ryonogawa.workclock.service.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping("/clock-in")
    @Transactional
    public String clockInRegistration(@RequestParam long userId, Model model) {
        service.clockIn(userId);
        model.addAttribute("attendance_kind", "出勤");
        return "complete";
    }

    @PostMapping("/clock-out")
    @Transactional
    public String clockOutRegistration(@RequestParam long userId, Model model) {
        try {
            service.clockOut(userId);
        } catch (Exception e) {
            System.out.println("退勤処理が異常終了しました");
        }
        model.addAttribute("attendance_kind", "退勤");
        return "complete";
    }

}
