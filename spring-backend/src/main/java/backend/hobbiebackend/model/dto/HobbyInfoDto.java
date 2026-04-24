package backend.hobbiebackend.model.dto;

import java.math.BigDecimal;

import backend.hobbiebackend.model.entities.enums.CategoryNameEnum;
import backend.hobbiebackend.model.entities.enums.LocationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HobbyInfoDto {
    private String name;
    private String slogan;
    private String intro;
    private String description;
    private CategoryNameEnum category;
    private String creator;
    private BigDecimal price;
    private LocationEnum location;
    private String contactInfo;
    private String profileImgUrl;
    private String galleryImgUrl1;
    private String galleryImgUrl2;
    private String galleryImgUrl3;
    private String profileImg_id;
    private String galleryImg1_id;
    private String galleryImg2_id;
    private String galleryImg3_id;

}
