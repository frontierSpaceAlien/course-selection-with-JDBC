/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

/**
 *
 * @author Derek Lien
 */
public class ValidateFields {

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Data validateEmail(String email) {
        Data data = new Data();
        data.validateEmail = email.matches(EMAIL_PATTERN);

        return data;
    }

    public Data validationUsername(String username) {
        Data data = new Data();
        data.validateUsername = username.equals("");

        return data;
    }

    public Data validationFname(String fName) {
        Data data = new Data();
        data.validateFname = fName.equals("");

        return data;
    }

    public Data validationlName(String lName) {
        Data data = new Data();
        data.validateLname = lName.equals("");

        return data;
    }

    public Data validationPassword(String password) {
        Data data = new Data();
        data.validatePassword = password.equals("");

        return data;
    }

    public String getEMAIL_PATTERN() {
        return EMAIL_PATTERN;
    }
}
