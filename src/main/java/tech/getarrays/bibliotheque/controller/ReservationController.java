/*package tech.getarrays.bibliotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Reservation;
import tech.getarrays.bibliotheque.service.ReservationService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/reservations")
public class ReservationController {


   private final ReservationService reservationService;


   @Autowired
   public ReservationController(ReservationService reservationService) {
       this.reservationService = reservationService;
   }


   @GetMapping("/form")
   public String showReservationForm(Model model) {
       model.addAttribute("reservation", new Reservation());
       return "reservation-form";
   }


   @PostMapping("/save")
   public String saveReservation(@Valid @ModelAttribute("reservation") Reservation reservation, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return "reservation-form";
       }
       reservationService.saveReservation(reservation);
       return "redirect:/reservations/all";
   }


   @GetMapping("/all")
   public String showAllReservations(Model model) {
       List<Reservation> reservations = reservationService.getAllReservations();
       model.addAttribute("reservations", reservations);
       return "all-reservations";
   }


   @GetMapping("/edit/{id}")
   public String showEditForm(@PathVariable Long id, Model model) {
       Optional<Reservation> reservation = reservationService.getReservationById(id);
       reservation.ifPresent(value -> model.addAttribute("reservation", value));
       return "reservation-form";
   }


   @GetMapping("/delete/{id}")
   public String deleteReservation(@PathVariable Long id) {
       reservationService.deleteReservation(id);
       return "redirect:/reservations/all";
   }


   @PutMapping("/update/{id}")
   public String updateReservation(@PathVariable Long id, @Valid @ModelAttribute("reservation") Reservation updatedReservation, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return "reservation-form";
       }


       Reservation updated = reservationService.updateReservation(id, updatedReservation);


       if (updated != null) {
           return "redirect:/reservations/all";
       } else {
           // Handle the case where the reservation with the given id is not found
           return "error-page"; // You can create an error page and redirect to it
       }
   }
}
*/
package tech.getarrays.bibliotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Reservation;
import tech.getarrays.bibliotheque.service.ReservationService;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/reservations")
public class ReservationController {


    private final ReservationService reservationService;


    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/create")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/create";
    }


    @PostMapping("/create")
    public String createReservation(@ModelAttribute Reservation reservation) {
        Reservation savedReservation = reservationService.saveReservation(reservation);
        // Redirect to the reservation details page after creating a reservation.
        return "redirect:/reservations/" + savedReservation.getId();
    }


    @GetMapping("/{id}")
    public String getReservationById(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        reservation.ifPresent(value -> model.addAttribute("reservation", value));
        // Use Thymeleaf template to display reservation details
        return "reservation/details";
    }


    @GetMapping("/all")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        // Use Thymeleaf template to display a list of reservations
        return "reservation/all";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        reservation.ifPresent(value -> model.addAttribute("reservation", value));
        // Use Thymeleaf template to display the update form
        return "reservation/update";
    }


    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation updatedReservation) {
        reservationService.updateReservation(id, updatedReservation);
        // Redirect to the reservation details page after updating a reservation.
        return "redirect:/reservations/" + id;
    }


    @PostMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        // Redirect to the reservation list page after deleting a reservation.
        return "redirect:/reservations/all";
    }
}

