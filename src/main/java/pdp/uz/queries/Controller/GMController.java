package pdp.uz.queries.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.queries.Entity.GM;
import pdp.uz.queries.Repository.GMRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/GM")
public class GMController {

    @Autowired
    GMRepository gmRepository;

    @GetMapping
    public List<GM> readGM(){

        List<GM> gmList = gmRepository.findAll();
        return gmList;

    }

    @PostMapping
    public String addGM(@RequestBody GM gm){
        gmRepository.save(gm);
        return "gm saved";
    }

    @DeleteMapping
    public String deleteGM(@PathVariable Integer id){
        gmRepository.deleteById(id);
        return "deleted";
    }

    @PutMapping
    public String updateGM(@PathVariable Integer id, @RequestBody GM gm){

        Optional<GM> optionalGM = gmRepository.findById(id);
        if(optionalGM.isPresent()){
           GM gm1 = optionalGM.get();
            gm1.setAddress(gm.getAddress());
            gm1.setCorpName(gm.getCorpName());
            gm1.setDirectorName(gm.getDirectorName());
            gmRepository.save(gm1);
            return "updated";
        }
        return "fail";
    }

}
