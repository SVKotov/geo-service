import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.i18n.LocalizationService;

import static ru.netology.entity.Country.*;


public class LocalizationServiceImplTest {

    @Test
    public void contentOfTheMessageByCountryTest () {

        LocalizationService localizationService = new LocalizationServiceImpl();

        Assertions.assertEquals(localizationService.locale(RUSSIA), "Добро пожаловать");
        Assertions.assertEquals(localizationService.locale(GERMANY), "Welcome");
        Assertions.assertEquals(localizationService.locale(USA), "Welcome");
        Assertions.assertEquals(localizationService.locale(BRAZIL), "Welcome");

    }

}

