package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Book;
import tech.getarrays.bibliotheque.models.Emprunt;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.service.EmpruntService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emprunts")
public class EmpruntController {

    private final EmpruntService empruntService;

    @Autowired
    public EmpruntController(EmpruntService empruntService) {

        this.empruntService = empruntService;
    }

    @PostMapping("/create")
    public String createEmprunt(@ModelAttribute Emprunt emprunt, Model model) {
        Book book = emprunt.getBook();
        User user = emprunt.getUser();
        LocalDate startDate = emprunt.getStartDate();
        LocalDate endDate = emprunt.getEndDate();

        empruntService.createEmprunt(user, startDate, endDate, book);

        model.addAttribute("message", "Emprunt créé avec succès");
        return "createEmprunt";
    }

    @GetMapping("/create")
    public String showCreateEmpruntForm(Model model) {
        model.addAttribute("emprunt", new Emprunt()); // Change to "emprunt" instead of "empruntRequest"
        return "createEmprunt"; // Provide the name of your Thymeleaf template for the form
    }

    @GetMapping("/{empruntId}")
    public String getEmpruntById(@PathVariable Long empruntId, Model model) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(empruntId);

        emprunt.ifPresent(value -> model.addAttribute("emprunt", value));
        return "emprunt"; // Provide the name of your Thymeleaf template
    }

    @GetMapping("/all")
    public String getAllEmprunts(Model model) {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        model.addAttribute("emprunts", emprunts);
        return "empruntList"; // Provide the name of your Thymeleaf template for listing
    }

    // ... (existing code)

    @GetMapping("/AllEmprunts")
    public String showFrontPage(Model model) {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        model.addAttribute("emprunts", emprunts);
        return "AllEmprunts"; // Provide the name of your Thymeleaf template for the front page
    }


}
