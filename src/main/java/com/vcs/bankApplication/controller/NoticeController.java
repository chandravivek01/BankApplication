package com.vcs.bankApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/notices")
    public String getNoticeDetails() {
        return "Here ate the notice details of the A/C";
    }
}
