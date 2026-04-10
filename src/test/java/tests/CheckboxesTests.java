package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckboxesPage;

import java.util.List;
import java.util.stream.Stream;

public class CheckboxesTests extends BaseTest {
    private CheckboxesPage page;

    @BeforeEach
    void setUp () {
        page = new CheckboxesPage();
    }

    @DisplayName("Open checkboxes page")
    @Test
    public void openCheckboxesPageTest () {
        page.openPage()
                .checkPageIsOpen();
    }

    @DisplayName("No checkboxes selected when page is open")
    @Test
    public void noCBSelectedTest() {
        page.openPage()
                .checkCBIsNotSelected(0)
                .checkCBIsNotSelected(1)
                .checkCBIsNotSelected(2);
    }

    @DisplayName("Select checkbox")
    @ParameterizedTest
    @ValueSource (ints = {0, 1, 2})
    public void selectCBTest(int index) {
        page.openPage()
                .clickCBByIndex(index)
                .checkCBIsSelected(index);
    }

    @DisplayName("Second click deselects selected checkbox")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void secondClickToCBTest(int index) {
        page.openPage()
                .clickCBByIndex(index)
                .checkCBIsSelected(index)
                .clickCBByIndex(index)
                .checkCBIsNotSelected(index);
    }

    @DisplayName("Second click deselects only one checkbox")
    @Test
    public void secondClickDeselectsOneCBTest() {
        page.openPage()
                .clickCBByIndex(0)
                .clickCBByIndex(1)
                .checkCBIsSelected(0)
                .checkCBIsSelected(1)
                .clickCBByIndex(1)
                .checkCBIsNotSelected(1)
                .checkCBIsSelected(0);
    }

    @DisplayName("Reset btn deselects all checkboxes selections")
    @ParameterizedTest
    @MethodSource("indexes")
    public void clickResetBtnTest(List<Integer> indexes) {
        page.openPage();
        for (Integer index : indexes) {
            page.clickCBByIndex(index)
                    .checkCBIsSelected(index);
        }
        page.clickResetBtn();
        for (SelenideElement checkbox : page.getEltsCheckBoxes()) {
            Assertions.assertFalse(checkbox.isSelected());
        }
    }

    private static Stream<Arguments> indexes() {
        return Stream.of(
                Arguments.of(List.of(0)),
                Arguments.of(List.of(0, 1)),
                Arguments.of(List.of(0, 1, 2))
        );
    }
}
