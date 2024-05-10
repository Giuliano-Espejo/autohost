package com.hostauto.demo.Controller;

import com.hostauto.demo.entity.A;
import com.hostauto.demo.repository.ARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/a")
public class AController {

    @Autowired
    ARepository aRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(aRepository.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
