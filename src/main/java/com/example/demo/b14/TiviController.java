package com.example.demo.b14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/b14/tivi")
public class TiviController {

    @Autowired
    private ITiviRepository repository;

    private final static int PAGE_SIZE = 5;

    @GetMapping
    public String viewAll(Model model
            , @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam(name = "name", required = false) String name
            , @RequestParam(name = "resolution", required = false) Integer resolution
    ) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        Page<Tivi> tiviPage;

        if (name != null && !name.isBlank()) {
            tiviPage = repository.timTheoTenPhanTrangVaSapXep("%" + name + "%", pageable);
        } else if (resolution != null) {
            tiviPage = repository.timTheoDoPhanGiaiPhanTrangVaSapXep(resolution, pageable);
        }
        else {
            tiviPage = repository.timTatPhanTrangVaSapXep(pageable);
        }

        model.addAttribute("tiviPage", tiviPage);
        return "b14/tivi";
    }

    @PostMapping
    public String add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "resolution") Integer resolution) {
        Tivi tivi = new Tivi();
        tivi.setTenTivi(name);
        tivi.setDoPhanGiai(resolution);

        repository.save(tivi);

        return "redirect:/b14/tivi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        repository.deleteById(id);

        return "redirect:/b14/tivi";
    }

    @GetMapping("/{id}")
    public String viewDetail(Model model, @PathVariable(name = "id") Integer id) {
        Tivi tivi = repository.findById(id).get();
        model.addAttribute("tivi", tivi);
        return "b14/tivi-detail";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable(name = "id") Integer id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "resolution") Integer resolution) {
        Tivi tivi = repository.findById(id).get();
        tivi.setTenTivi(name);
        tivi.setDoPhanGiai(resolution);

        repository.save(tivi);

        return "redirect:/b14/tivi";
    }

    @GetMapping("/resolution")
    public String countResolution(Model model) {
        List<TiviResolution> tiviResolutions = repository.thongKeDoPhanGiaiCuaTivi();
        model.addAttribute("tiviResolutions", tiviResolutions);
        return "b14/resolution";
    }
}
