package com.example.projetfinale.controllers;

import com.example.projetfinale.models.Vols;
import com.example.projetfinale.services.VolsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vols")
@CrossOrigin
public class VolsController {

    private final VolsService service;
    VolsController(VolsService service) {
        this.service = service;
    }

    @GetMapping("search/{origine_id}/{dst_id}/{date}/{section}")
    public List<Vols> search(@PathVariable int origine_id, @PathVariable int dst_id, @PathVariable String date, @PathVariable String section) {
        return service.searchVols(origine_id, dst_id, date, section);
    }
}
