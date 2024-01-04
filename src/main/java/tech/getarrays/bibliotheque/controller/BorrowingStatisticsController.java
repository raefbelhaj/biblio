package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.getarrays.bibliotheque.models.BorrowingStatistics;
import tech.getarrays.bibliotheque.service.BorrowingStatisticsService;

@Controller
public class BorrowingStatisticsController {

    @Autowired
    private BorrowingStatisticsService borrowingStatisticsService;

    @GetMapping("/borrowing-statistics")
    public String showBorrowingStatistics(Model model) {
        BorrowingStatistics statistics = borrowingStatisticsService.generateBorrowingStatistics();
        model.addAttribute("borrowingStatistics", statistics);
        return "borrowing-statistics"; // Thymeleaf template name (borrowing-statistics.html)
    }
}
