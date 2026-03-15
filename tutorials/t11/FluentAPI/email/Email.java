package FluentAPI.email;

public class Email {
    private final String from;
    private final String to;
    private final String subject;
    private final String body;
    private final String cc;

    public Email(String from, String to, String subject, String body, String cc) {
        this.from = from; this.to = to; this.subject = subject;
        this.body = body; this.cc = cc;
    }

    @Override
    public String toString() {
        return "From:    " + from + "\n"
             + "To:      " + to + "\n"
             + (cc != null ? "CC:      " + cc + "\n" : "")
             + "Subject: " + subject + "\n"
             + "Body:    " + body;
    }
}