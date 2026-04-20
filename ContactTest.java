import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        assertEquals("001", contact.getContactId());
        assertEquals("Isaac", contact.getFirstName());
        assertEquals("Silva", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Isaac", "Silva", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Isaac", "Silva", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", null, "Silva", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Christopher", "Silva", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", "Christopher", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", "Silva", null, "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", "Silva", "12345", "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", "Silva", "1234567890", null);
        });
    }

    @Test
    public void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Isaac", "Silva", "1234567890",
                    "123 This Address Is Definitely Way Too Long");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        contact.setFirstName("Chris");
        assertEquals("Chris", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        contact.setLastName("Jones");
        assertEquals("Jones", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        contact.setAddress("456 Oak Avenue");
        assertEquals("456 Oak Avenue", contact.getAddress());
    }
}