package com.ptaq131218;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class PtaqTest {

    @Test
    public void verifyCapgeminiPage(){
        open("https://www.capgemini.com/pl-pl/");
        $$(".menu>li").shouldHave(CollectionCondition.size(7));
        //this selector selects career from main menu by id
        $("#menu-item-11201")
                .hover();
        $$(".sub-menu>li>a")
                .stream()
                .filter(el -> el.getText().contains("Kontakt"))
        .findFirst()
        .get()
        .click();

        $("#nf-field-529").setValue("first_name second_name");
        $("#nf-field-530").setValue("exampleemail@gmail.com");
        $("#nf-field-531").setValue("message");
        $(".section__button--cookies").click();
        $("#nf-field-532").scrollTo().click();
        $(".form__sent").shouldHave(Condition.text("Success!"));
    }
}
