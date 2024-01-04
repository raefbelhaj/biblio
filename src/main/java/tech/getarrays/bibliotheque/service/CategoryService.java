package tech.getarrays.bibliotheque.service;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.bibliotheque.Repo.CategoryRepo;
import tech.getarrays.bibliotheque.models.category;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
@Service

public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Optional<category> getCategoryById(Long categoryId) {
        return categoryRepo.findById(categoryId);
    }

    public void addCategory( category category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepo.deleteById(categoryId);
    }
}
