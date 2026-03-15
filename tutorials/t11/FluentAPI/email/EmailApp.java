package FluentAPI.email;

public class EmailApp {
    public static void main(String[] args) {
        Email e1 = new EmailBuilder()
            .from("alice@example.com")
            .to("bob@example.com")
            .subject("Meeting tomorrow")
            .body("Hi Bob, are you free at 10am?")
            .cc("carol@example.com")
            .build();
        System.out.println(e1);
        System.out.println("---");

        // Missing subject — triggers validation
        try {
            Email e2 = new EmailBuilder()
                .from("alice@example.com")
                .to("dave@example.com")
                .body("Forgot the subject line!")
                .build();
        } catch (IllegalStateException ex) {
            System.out.println("Build failed: " + ex.getMessage());
        }
    }
}
