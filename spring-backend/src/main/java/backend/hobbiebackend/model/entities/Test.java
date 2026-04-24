package backend.hobbiebackend.model.entities;

import backend.hobbiebackend.model.entities.enums.CategoryNameEnum;
import backend.hobbiebackend.model.entities.enums.LocationEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test_results")
@Setter
@NoArgsConstructor
public class Test extends BaseEntity {
    private String username;
    private CategoryNameEnum categoryOne;
    private CategoryNameEnum categoryTwo;
    private CategoryNameEnum categoryThree;
    private CategoryNameEnum categoryFour;
    private CategoryNameEnum categoryFive;
    private CategoryNameEnum categorySix;
    private CategoryNameEnum categorySeven;
    private LocationEnum location;

    @Column
    public String getUsername() {
        return username;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_one")
    public CategoryNameEnum getCategoryOne() {
        return categoryOne;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_two")
    public CategoryNameEnum getCategoryTwo() {
        return categoryTwo;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_three")
    public CategoryNameEnum getCategoryThree() {
        return categoryThree;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_four")
    public CategoryNameEnum getCategoryFour() {
        return categoryFour;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_five")
    public CategoryNameEnum getCategoryFive() {
        return categoryFive;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_six")
    public CategoryNameEnum getCategorySix() {
        return categorySix;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_seven")
    public CategoryNameEnum getCategorySeven() {
        return categorySeven;
    }

    @Enumerated(EnumType.STRING)
    public LocationEnum getLocation() {
        return location;
    }
    
    
    
    
}
