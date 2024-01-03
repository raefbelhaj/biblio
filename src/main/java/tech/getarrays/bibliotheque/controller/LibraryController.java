package tech.getarrays.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping("/library")
    public String showLibraryPage() {
        return "library";
    }


}