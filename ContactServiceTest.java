import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");

        service.addContact(contact);

        assertEquals("Isaac", service.getContact("001").getFirstName());
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        Contact contact2 = new Contact("001", "Chris", "Jones", "0987654321", "456 Oak Avenue");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("001");

        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("001");
        });
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateFirstName("001", "Chris");

        assertEquals("Chris", service.getContact("001").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateLastName("001", "Jones");

        assertEquals("Jones", service.getContact("001").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updatePhone("001", "0987654321");

        assertEquals("0987654321", service.getContact("001").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Isaac", "Silva", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateAddress("001", "456 Oak Avenue");

        assertEquals("456 Oak Avenue", service.getContact("001").getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Chris");
        });
    }
}