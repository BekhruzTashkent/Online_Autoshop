package pdp.uz.queries.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pdp.uz.queries.Entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    //native query to find car by AutoShopId

    @Query (value = "select * \n" +
            "from car c\n" +
            "         join autoshop a on c.auto_shop_id = a.id\n" +
            "where c.auto_shop_id = : autoShopId", nativeQuery = true)
    List<Car> getCarByAutoShopId (Integer autoShopId);

}
