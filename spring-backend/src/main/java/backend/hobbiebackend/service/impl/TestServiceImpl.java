package backend.hobbiebackend.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.hobbiebackend.model.entities.AppClient;
import backend.hobbiebackend.model.entities.Hobby;
import backend.hobbiebackend.model.entities.Test;
import backend.hobbiebackend.model.repostiory.TestRepository;
import backend.hobbiebackend.service.HobbyService;
import backend.hobbiebackend.service.TestService;
import backend.hobbiebackend.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final UserService userService;
    private final HobbyService hobbyService;

    @Override
    public void saveTestResults(Test results) {
        AppClient currentUserAppClient = this.userService.findAppClientByUsername(results.getUsername());
        if (currentUserAppClient.getTestResults() != null) {
            results.setId(currentUserAppClient.getTestResults().getId());
        }
        this.testRepository.save(results);
        currentUserAppClient.setTestResults(results);

        Set<Hobby> hobbyMatches = this.hobbyService.findHobbyMatches(currentUserAppClient.getUsername());
        currentUserAppClient.setHobbyMatches(hobbyMatches);
        this.userService.saveUpdatedUserClient(currentUserAppClient);
    }
}
