/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Derek Lien
 */
public class ValidateFieldsTest {

    private ValidateFields validateFields;

    public ValidateFieldsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        validateFields = new ValidateFields();
    }

    @After
    public void tearDown() {
    }

    /**
     * The point of the following test cases is to test the functionality in the
     * ValidateFields class.
     *
     * There are 5 methods in the ValidateFields class. This only tests 2
     * methods from that class.
     *
     * It is redundant to test all 5 as 4 of them are essentially the same. The
     * first test is important as it tests the format of the string.
     * 
     * There is also the testValidateEmailFormat test case which tests if the string
     * is not in an email format.
     * 
     * The remaining test cases tests for a string input and an empty string. Both of 
     * which are important because when the user registers, the program needs to recognize
     * if there is an empty field or a string not within an email format.
     *
     */
    
    /**
     * This tests the validation for strings in an email format. The expected
     * result should return true.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email = "testEmail@Email.com";
        ValidateFields instance = new ValidateFields();
        Data expResult = new Data();
        expResult.validateEmail = true;
        Data result = instance.validateEmail(email);
        assertEquals(expResult.validateEmail, result.validateEmail);
    }

    /**
     * This tests the validation for any string that is not in an email format.
     * The expected result should return false
     */
    @Test
    public void testValidateEmailFormat() {
        System.out.println("validateEmailFormat");
        String email = "testEmailFormat";
        ValidateFields instance = new ValidateFields();
        Data expResult = new Data();
        expResult.validateEmail = false;
        Data result = instance.validateEmail(email);
        assertEquals(expResult.validateEmail, result.validateEmail);
    }

    /**
     * This tests for a string The expected result should return false.
     */
    @Test
    public void testValidationUsername() {
        System.out.println("validationUsername");
        String username = "test username";
        ValidateFields instance = new ValidateFields();
        Data expResult = new Data();
        expResult.validateUsername = false;
        Data result = instance.validationUsername(username);
        assertEquals(expResult.validateUsername, result.validateUsername);

    }

    /**
     * This tests for an empty string. The expected result should return true.
     */
    @Test
    public void testValidationUsernameEmpty() {
        System.out.println("validationUsernameEmpty");
        String username = "";
        ValidateFields instance = new ValidateFields();
        Data expResult = new Data();
        expResult.validateUsername = true;
        Data result = instance.validationUsername(username);
        assertEquals(expResult.validateUsername, result.validateUsername);

    }

}
