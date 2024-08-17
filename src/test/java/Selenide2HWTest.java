import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Selenide2HWTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
    }

    String hText ="The AI-powered developer platform";

    @Test
    void selenide2hw(){

        //Открыть страницу
        open("/dashboard");

        //Поиск таба  Solution
        $$("button").findBy(text("Solutions")).hover();

        //Поиск опции в выпадающем списке
        $(byTagAndText("a","Enterprise")).click();

        // Проверка текста заголовка
        $$("#hero-section-brand-heading").shouldHave(texts(hText));
    }
}
