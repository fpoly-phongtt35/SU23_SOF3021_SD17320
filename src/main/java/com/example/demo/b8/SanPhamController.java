package com.example.demo.b8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller("B8Controller")
@RequestMapping("/b8/san-pham")
public class SanPhamController {

    @Autowired
    private ISanPhamRepository repository;

    @GetMapping
    public String view(Model model,
                       @RequestParam(required = false) String tenSanPham) {

        List<SanPham> sanPhamList = new ArrayList<>();

        if (tenSanPham == null || tenSanPham.isBlank()) {
            sanPhamList = repository.findAll();
        } else {
            sanPhamList = repository.findByTenSanPhamContains(tenSanPham);
        }

        model.addAttribute("danhSachSanPham", sanPhamList);

        return "b8/product";
    }

}
