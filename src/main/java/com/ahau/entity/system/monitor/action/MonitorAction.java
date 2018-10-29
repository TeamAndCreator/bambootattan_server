package com.ahau.entity.system.monitor.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * druid 监控
 * created by: 张理
 * 2018-10-28 19：10
 */
@Controller
@RequestMapping("/system/monitor")
public class MonitorAction {
    @RequestMapping("/viewMonitor")
    public ModelAndView getMonitor() {
        return new ModelAndView("/system/monitor/viewMonitor");
    }
}
