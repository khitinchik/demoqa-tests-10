package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OneTest {
    @BeforeAll
    static void Size() {
        Configuration.browserSize = "1366x768";
    }

    @Test
    void page() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Nastya");
        $("#lastName").setValue("Khitina");
        $("#userEmail").setValue("nasok97@mail.ru");
        $("label[for='gender-radio-2']").click();
        //      $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9277047002");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();

        $(".table-responsive").shouldHave(
                text("Nastya"),
                text("Khitina"),
                text("nasok97@mail.ru"),
                text("Female"),
                text("9277047002"),
                text("20 December,2000"),
                text("English"),
                text("Sports"),
                text("1.png"),
                text("address"),
                text("NCR Delhi"));

        sleep(17000);
    }
}