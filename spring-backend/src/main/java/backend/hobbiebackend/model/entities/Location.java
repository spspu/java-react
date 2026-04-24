package backend.hobbiebackend.model.entities;

import backend.hobbiebackend.model.entities.enums.LocationEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Location extends BaseEntity {

    private LocationEnum name;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public LocationEnum getName() {
        return name;
    }
}
