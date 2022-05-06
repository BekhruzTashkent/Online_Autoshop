package pdp.uz.queries.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.queries.Entity.AutoShop;
import pdp.uz.queries.Entity.GM;
import pdp.uz.queries.Payload.AutoShopDto;
import pdp.uz.queries.Repository.AutoShopRepository;
import pdp.uz.queries.Repository.GMRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autoshop")
public class AutoShopController {

    @Autowired
    AutoShopRepository autoShopRepository;
    @Autowired
    GMRepository gmRepository;

    @GetMapping
    public List<AutoShop> readAutoShops(){

        List<AutoShop> autoShopList = autoShopRepository.findAll();
        return autoShopList;

    }

    @GetMapping("/{GMId}")
    public List<AutoShop> readByGMId(@PathVariable Integer GMId){
   //     List<AutoShop> autoShopList = autoShopRepository.findAllByGMId(GMId);
        return null;
    }



    @PostMapping
    public String addAutoshop(@RequestBody AutoShopDto autoShopDto){
        AutoShop autoShop = new AutoShop();
        autoShop.setAddress(autoShopDto.getAddressAutoShop());
        autoShop.setName(autoShopDto.getName());

        Optional<GM> optionalGM = gmRepository.findById(autoShopDto.getGMId());
        if(optionalGM.isPresent()){
            autoShop.setGm(optionalGM.get());
            autoShopRepository.save(autoShop);
        }
        return "fail";
    }

    @PutMapping("/{autoShopId}")
    public String updateAutoShop(@PathVariable Integer autoShopId, @RequestBody AutoShopDto autoShopDto){
        Optional<AutoShop> optionalAutoShop = autoShopRepository.findById(autoShopId);
        if(optionalAutoShop.isPresent()){
            AutoShop autoShop = optionalAutoShop.get();
            autoShop.setName(autoShopDto.getName());
            autoShop.setName(autoShopDto.getName());
            autoShopRepository.save(autoShop);
            return "updated";
        }
        return "false";
    }

    @DeleteMapping("/{autoShopId}")
    public String deleteAutoShop(@PathVariable Integer autoShopId){
        autoShopRepository.deleteById(autoShopId);
        return "deleted";
    }


}
