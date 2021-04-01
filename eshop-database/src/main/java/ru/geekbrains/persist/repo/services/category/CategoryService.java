package ru.geekbrains.persist.repo.services.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> showAllCategories();

    Optional<CategoryDTO> findById(Long id);

    void delete(Long id);

    void save(CategoryDTO categoryDTO);

}
