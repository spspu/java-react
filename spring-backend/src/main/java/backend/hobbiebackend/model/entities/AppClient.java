package backend.hobbiebackend.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.hobbiebackend.model.entities.enums.GenderEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_clients")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@Setter
public class AppClient extends UserEntity implements Serializable {

    private String fullName;
    private GenderEnum gender;
    private Test testResults;
    private Set<Hobby> hobbyMatches = new HashSet<>();
    private List<Hobby> savedHobbies;

    public AppClient(
            String username,
            String email,
            List<UserRoleEntity> roles,
            String password,
            String fullName,
            GenderEnum gender
    ) {
        super(username, email, roles, password);
        this.fullName = fullName;
        this.gender = gender;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public GenderEnum getGender() {
        return gender;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "test_result_id", referencedColumnName = "id")
    public Test getTestResults() {
        return testResults;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_hobby_matches",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id")
    )
    public Set<Hobby> getHobbyMatches() {
        return hobbyMatches;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_saved_hobbies",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id")
    )
    public List<Hobby> getSavedHobbies() {
        return savedHobbies;
    }
}