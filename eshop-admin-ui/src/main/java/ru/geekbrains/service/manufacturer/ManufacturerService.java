package ru.geekbrains.service.manufacturer;

import ru.geekbrains.controller.DTO.ManufacturerDTO;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<ManufacturerDTO> showAllManufacturers();

    Optional<ManufacturerDTO> findManufacturerById(Long id);

    void delete(Long id);

    void save(ManufacturerDTO manufacturerDTO);
}
