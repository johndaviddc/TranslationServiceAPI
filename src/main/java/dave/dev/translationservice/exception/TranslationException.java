package dave.dev.translationservice.exception;

public class TranslationException extends RuntimeException {
    public TranslationException(String message, Throwable cause) {
        super(message, cause);
    }
}
