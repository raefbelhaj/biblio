package tech.getarrays.bibliotheque.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import tech.getarrays.bibliotheque.models.User;

import java.time.LocalDate;

public class EmpruntRequest {

    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public EmpruntRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        // Retourne un objet User basé sur l'ID de l'utilisateur
        // Vous devez définir la logique pour récupérer l'utilisateur en fonction de l'ID
        // Par exemple, vous pourriez utiliser un service User
        User user = new User(); // Remplacez cela par la logique réelle
        user.setId(userId);
        return user;
    }
}
