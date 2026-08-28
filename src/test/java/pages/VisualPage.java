package pages;

import config.Config;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class VisualPage extends PageHelper<VisualPage>{

    @Override
    protected VisualPage self() {
        return Objects.requireNonNull(this);
    }

    public VisualPage openPage() {
        open(Config.getPageUrl("visualEndpoint"));
        return this;
    }
}
