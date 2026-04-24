package backend.hobbiebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBusinessDto {
    private Long id;
    private String businessName;
    private String address;
    private String password;

}
