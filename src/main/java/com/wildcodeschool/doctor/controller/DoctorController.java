package com.wildcodeschool.doctor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.doctor.model.Doctor;

@Controller
public class DoctorController {
    /*@GetMapping("/")
    public String index() {
        return "index.html";
    }*/
    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
        if (number == 13) {
            return new Doctor(13, "Jodie Whittaker");
        } else if (number > 0 && number < 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303 See Other");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
        }
    }
}
