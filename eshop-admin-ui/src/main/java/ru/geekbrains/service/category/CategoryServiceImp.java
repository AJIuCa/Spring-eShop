package ru.geekbrains.service.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.DTO.CategoryDTO;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> showAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDTO::new);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void save(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setTitle(categoryDTO.getTitle());
        categoryRepository.save(category);

    }
}
