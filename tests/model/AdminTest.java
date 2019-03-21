package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {
    private Admin bob = new Admin("Bob","Bean","bob@bean.com","Bob","Password");

    @Test
    public void getAttributes() {
        assertEquals("Bob",bob.getFirstName());
        assertEquals("Bean",bob.getLastName());
        assertEquals("bob@bean.com",bob.getEmailAddress());
        assertEquals("Bob",bob.getUsername());
        assertEquals("Password",bob.getPassword());
        assertEquals("Admin",bob.getUserType());
    }
}