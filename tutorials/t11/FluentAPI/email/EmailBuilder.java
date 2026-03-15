package FluentAPI.email;

public class EmailBuilder {
    private String from;
    private String to;
    private String subject;
    private String body;
    private String cc;

    public EmailBuilder from(String from) {
        this.from = from; return this;
    }
    public EmailBuilder to(String to) {
        this.to = to; return this;
    }
    public EmailBuilder subject(String subject) {
        this.subject = subject; return this;
    }
    public EmailBuilder body(String body) {
        this.body = body; return this;
    }
    public EmailBuilder cc(String cc) {
        this.cc = cc; return this;
    }

    public Email build() {
        if (to == null || to.isBlank())
            throw new IllegalStateException("Email must have a recipient (to).");
        if (subject == null || subject.isBlank())
            throw new IllegalStateException("Email must have a subject.");
        return new Email(from, to, subject, body, cc);
    }
}
