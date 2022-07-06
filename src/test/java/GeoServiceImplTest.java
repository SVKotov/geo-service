import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static ru.netology.geo.GeoServiceImpl.*;


public class GeoServiceImplTest {


    @Test
    public void locationByIpUsaTest() {
        GeoService geoService = new GeoServiceImpl();

        Location usaLocatoin = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location locationByIp = geoService.byIp(NEW_YORK_IP);

        Assertions.assertEquals(usaLocatoin.getCountry() , locationByIp.getCountry());
    }

    @Test
    public void locationByIpRuTest() {
        GeoService geoService = new GeoServiceImpl();

        Location usaLocatoin = new Location("Moscow", Country.RUSSIA, null, 0);
        Location locationByIp = geoService.byIp(MOSCOW_IP);

        Assertions.assertEquals(usaLocatoin.getCountry() , locationByIp.getCountry());
    }

}
