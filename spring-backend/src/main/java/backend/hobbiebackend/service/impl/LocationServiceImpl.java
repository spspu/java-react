package backend.hobbiebackend.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import backend.hobbiebackend.handler.NotFoundException;
import backend.hobbiebackend.model.entities.Location;
import backend.hobbiebackend.model.entities.enums.LocationEnum;
import backend.hobbiebackend.model.repostiory.LocationRepository;
import backend.hobbiebackend.service.LocationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;


    @Override
    public List<Location> initLocations() {
        List<Location> init = new ArrayList<>();
        if (locationRepository.count() == 0) {
            Arrays.stream(LocationEnum.values()).forEach(locationEnum -> {
                Location location = new Location(locationEnum);
                this.locationRepository.save(location);
                init.add(location);
            });
        }
        return init;
    }

    @Override
    public Location getLocationByName(LocationEnum locationEnum) {
        Optional<Location> location = this.locationRepository.findByName(locationEnum);
        if (location.isPresent()) {
            return location.get();
        } else {
            throw new NotFoundException("Location not found");
        }
    }
}
