package pdp.uz.queries.Payload;

import lombok.Data;

@Data
public class AutoShopDto {

//    private String addressGM;
//    private String corpName;
//    private String directorName;
    private String name;
    private String addressAutoShop;
    private Integer GMId;  //several autoshop in one GM

}
