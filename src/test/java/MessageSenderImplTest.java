import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.*;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderImplTest {


    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
    MessageSenderImpl messageSender = Mockito.mock(MessageSenderImpl.class);

    @Test
    public void matchingTextLanguageToTheCountryRUTest() {

        messageSender = new MessageSenderImpl(geoService, localizationService);

        Mockito.when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String expected = "Добро пожаловать";
        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void matchingTextLanguageToTheCountryUSATest() {

        messageSender = new MessageSenderImpl(geoService, localizationService);

        Mockito.when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String expected = "Welcome";
        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);

    }

}

