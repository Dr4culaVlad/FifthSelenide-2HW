import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;


public class DrugnDropHWTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void drugNDropActions() {

        // Переход на страницу
        open("/drag_and_drop");

        //Проверка начального положения жлементов.
        $("div #column-a header").shouldHave(text("A"));
        $("div #column-b header").shouldHave(text("B"));

        // Перенос элементов
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(209, 0).release().perform();

        // Проверка, что элементы перенесены
        $("div #column-a header").shouldHave(text("B"));
        $("div #column-b header").shouldHave(text("A"));

    }

    @Test
    void drugNDrop() {

        // Переход на страницу
        open("/drag_and_drop");

        //Проверка начального положения жлементов.
        $("div #column-a header").shouldHave(text("A"));
        $("div #column-b header").shouldHave(text("B"));

        // Перенос элементов
        $("#column-a").dragAndDrop(to("#column-b"));

        // Проверка, что элементы перенесены
        $("div #column-a header").shouldHave(text("B"));
        $("div #column-b header").shouldHave(text("A"));
    }

}