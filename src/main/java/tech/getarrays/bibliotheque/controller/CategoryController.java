/*package tech.getarrays.bibliotheque.controller;






import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.category;
import tech.getarrays.bibliotheque.service.CategoryService;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {


   @Autowired
   private CategoryService categoryService;








   @GetMapping("/all")
   public ResponseEntity<List<category>> getAllCategories() {
       List<category> categories = categoryService.getAllCategories();
       return new ResponseEntity<>(categories, HttpStatus.OK);
   }
   @GetMapping("/{categoryId}")
   public ResponseEntity<category> getCategoryById(@PathVariable Long categoryId) {
       Optional<category> category = categoryService.getCategoryById(categoryId);
       return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }




   @PostMapping
   public ResponseEntity<category> addCategory(@RequestBody category category) {
       categoryService.addCategory(category);
       return new ResponseEntity<>(category, HttpStatus.CREATED);
   }


   @DeleteMapping("/{categoryId}")
   public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
       categoryService.deleteCategory(categoryId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}*/
package tech.getarrays.bibliotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.category;
import tech.getarrays.bibliotheque.service.CategoryService;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public String getAllCategories(Model model) {
        List<category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/list";
    }


    @GetMapping("/{categoryId}")
    public String getCategoryById(@PathVariable Long categoryId, Model model) {
        Optional<category> category = categoryService.getCategoryById(categoryId);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "category/view";
    }


    @GetMapping("/new")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new category());
        return "category/new";
    }


    @PostMapping("/new")
    public String addCategory(@ModelAttribute category category) {
        categoryService.addCategory(category);
        return "redirect:/categories/all";
    }


    @GetMapping("/edit/{categoryId}")
    public String showEditForm(@PathVariable Long categoryId, Model model) {
        Optional<category> category = categoryService.getCategoryById(categoryId);
        category.ifPresent(value -> model.addAttribute("category", value));
        return "category/edit";
    }


   /*@PostMapping("/edit/{categoryId}")
   public String updateCategory(@PathVariable Long categoryId, @ModelAttribute category updatedCategory) {
       categoryService.updatecategory(categoryId, updatedCategory);
       return "redirect:/categories/all";
   }*/


    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories/all";
    }
}

