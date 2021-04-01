package ru.geekbrains.persist.repo.services.manufacturer;

import ru.geekbrains.persist.repo.services.role.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<ManufacturerDTO> showAllManufacturers();

    Optional<ManufacturerDTO> findManufacturerById(Long id);

    void delete(Long id);

    void save(ManufacturerDTO manufacturerDTO);
}
