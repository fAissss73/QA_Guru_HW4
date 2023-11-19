import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;




public class ExampleCodeJUnit5 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void searchJUnit5() {
        //Открыть страницу GitHub selenide
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki
        $("#wiki-tab").click();
        //Убедится, что в списке страниц (Pages) есть страница SoftAssertions
        $("div.Layout-main").shouldHave(text("Soft assertions"));
        //Перейти на страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $("div.Layout-main").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class")
                .closest("h4").sibling(0).shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                         @Test
                        void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                        }
                        }"""));
    }

}
