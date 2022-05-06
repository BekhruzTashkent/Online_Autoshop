package pdp.uz.queries.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pdp.uz.queries.Entity.AutoShop;

import java.util.List;

public interface AutoShopRepository extends JpaRepository<AutoShop, Integer> {

//List<AutoShop> findAllByGMId(Integer id);

}
