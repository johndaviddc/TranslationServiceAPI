package dave.dev.translationservice.service;

import dave.dev.translationservice.model.Translation;
import dave.dev.translationservice.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public Translation translateText(String sourceLanguage, String targetLanguage, String sourceText) {
        try {
            Translate translate = TranslateOptions.getDefaultInstance().getService();
            Translation translationResult = translate.translate(sourceText, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                    Translate.TranslateOption.targetLanguage(targetLanguage));

            Translation translationEntity = new Translation();
            translationEntity.setSourceLanguage(sourceLanguage);
            translationEntity.setTargetLanguage(targetLanguage);
            translationEntity.setSourceText(sourceText);
            translationEntity.setTranslatedText(translationResult.getTranslatedText());

            return translationRepository.save(translationEntity);
        } catch (Exception e) {
            throw new TranslationException("Error translating text", e);
        }
    }
}
