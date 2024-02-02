package dave.dev.translationservice.controller;

import dave.dev.translationservice.model.Translation;
import dave.dev.translationservice.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translate")
public class TranslationController {
    @Autowired
    private TranslationService translationService;

    @PostMapping
    public Translation translate(@RequestBody Translation translationRequest) {
        return translationService.translateText(
                translationRequest.getSourceLanguage(),
                translationRequest.getTargetLanguage(),
                translationRequest.getSourceText()
        );
    }
}
