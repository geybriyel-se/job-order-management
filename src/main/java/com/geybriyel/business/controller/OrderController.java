package com.geybriyel.business.controller;

import com.geybriyel.business.entity.RepairJO;
import com.geybriyel.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.server.RemoteRef;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<RepairJO> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders/order-list";
    }
}
