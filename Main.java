public class Main {
    public static void main(String[] args) {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Angel", "Silva", "1234567890", "123 Main Street");
        service.addContact(contact);
        System.out.println(service.getContact("001").getFirstName());
    }
}