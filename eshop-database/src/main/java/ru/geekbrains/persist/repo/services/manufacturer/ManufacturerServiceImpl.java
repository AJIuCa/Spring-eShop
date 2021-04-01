package ru.geekbrains.persist.repo.services.manufacturer;

import ru.geekbrains.persist.model.Manufacturer;
import ru.geekbrains.persist.repo.ManufacturerRepository;
import ru.geekbrains.persist.repo.services.role.RoleDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerDTO> showAllManufacturers() {
        return manufacturerRepository.findAll()
                .stream()
                .map(ManufacturerDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ManufacturerDTO> findManufacturerById(Long id) {
        return manufacturerRepository.findById(id)
                .map(ManufacturerDTO::new);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public void save(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerDTO.getId());
        manufacturer.setTitle(manufacturerDTO.getTitle());
        manufacturerRepository.save(manufacturer);

    }
}
