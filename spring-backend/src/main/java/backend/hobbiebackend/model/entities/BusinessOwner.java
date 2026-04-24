package backend.hobbiebackend.model.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business_owners")
@PrimaryKeyJoinColumn(name = "id")
@Setter
@NoArgsConstructor
public class BusinessOwner extends UserEntity {

    private String businessName;
    private String address;
    private Set<Hobby> hobbyOffers = new HashSet<>();

    public BusinessOwner(
            String username,
            String email,
            List<UserRoleEntity> roles,
            String password,
            String businessName,
            String address
    ) {
        super(username, email, roles, password);
        this.businessName = businessName;
        this.address = address;
    }

    @Column(name = "business_name", nullable = false)
    public String getBusinessName() {
        return businessName;
    }

    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "business_owner_hobbies",
            joinColumns = @JoinColumn(name = "business_owner_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id")
    )
    public Set<Hobby> getHobbyOffers() {
        return hobbyOffers;
    }
}