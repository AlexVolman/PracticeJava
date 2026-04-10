package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.Config;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

    public class CheckboxesPage extends PageHelper<CheckboxesPage> {
    private final SelenideElement eltCheckboxesGroup = $(".form-group");
    private final SelenideElement eltResetBtn = $(".btn-primary");
    private final ElementsCollection eltsCheckBoxes = $$(".form-check-input");

    @Override
    protected CheckboxesPage self() {return Objects.requireNonNull(this);}

    public CheckboxesPage openPage() {
        open(Config.getPageUrl("checkBoxesEndpoint"));
        return this;
    }

    public void checkPageIsOpen() {
        eltCheckboxesGroup.shouldBe(Condition.visible);
    }

    public SelenideElement getCBByIndex(int index) {
        return eltsCheckBoxes.get(index);
    }

    public CheckboxesPage checkCBIsNotSelected(int index) {
        Assertions.assertFalse(eltsCheckBoxes.get(index).isSelected());
        return this;
    }

    public CheckboxesPage checkCBIsSelected(int index) {
        Assertions.assertTrue(eltsCheckBoxes.get(index).isSelected());
        return this;
    }

    public void clickResetBtn() {
        eltResetBtn.shouldBe(Condition.visible).click();
    }

    public CheckboxesPage clickCBByIndex(int index) {
        getCBByIndex(index).click();
        return this;
    }

    public ElementsCollection getEltsCheckBoxes () {
        return eltsCheckBoxes;
    }
}
