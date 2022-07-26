package steps;

import io.qameta.allure.Step;

public class HealsCheckSteps {

    @Step("Check login: '{login}' and password: '{password}'")
    public boolean checkLoginAndPassword(String login, String password) {
        return login.length() > 6 && password.length() > 6;
    }

}
