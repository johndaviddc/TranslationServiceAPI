package dave.dev.translationservice.service;

import dave.dev.translationservice.model.Translation;

public interface TranslationService {
    Translation translateText(String sourceLanguage, String targetLanguage, String sourceText);
}
