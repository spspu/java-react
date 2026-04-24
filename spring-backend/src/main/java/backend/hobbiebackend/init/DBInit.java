package backend.hobbiebackend.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import backend.hobbiebackend.service.CategoryService;
import backend.hobbiebackend.service.HobbyService;
import backend.hobbiebackend.service.LocationService;
import backend.hobbiebackend.service.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final HobbyService hobbyService;
    private final LocationService locationService;

    @Override
    public void run(String... args) throws Exception {
        this.userService.seedUsersAndUserRoles();
        this.categoryService.initCategories();
        this.locationService.initLocations();
    }

}
