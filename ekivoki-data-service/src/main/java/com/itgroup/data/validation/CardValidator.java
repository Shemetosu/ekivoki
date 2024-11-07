package com.itgroup.data.validation;

import com.itgroup.data.exception.ValidationException;
import com.itgroup.data.repository.dao.CardRepository;
import com.itgroup.data.repository.dao.CardTopicRepository;
import com.itgroup.data.repository.dao.CardTypeRepository;
import com.itgroup.data.util.StringUtils;
import com.itgroup.model.dto.request.CardCreateDto;
import com.itgroup.model.dto.request.CardUpdateDto;
import com.itgroup.model.dto.request.UserCardCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CardValidator {

    private final CardTopicRepository cardTopicRepository;
    private final CardTypeRepository cardTypeRepository;
    private final CardRepository cardRepository;

    public void checkCardCreate(CardCreateDto dto) {
        if (!cardTopicRepository.existsById(dto.getTopicId())) {
            throw new ValidationException("Указанного топика не существует");
        }
        if (!cardTypeRepository.existsById(dto.getTypeId())) {
            throw new ValidationException("Указанного типа не существует");
        }
        if (cardRepository.existsByTask(dto.getTask())) {
            throw new ValidationException("Указанное задание уже существует");
        }
        if (cardRepository.existsByQuestion(dto.getQuestion())) {
            throw new ValidationException("Указанный вопрос уже существует");
        }
    }

    public void checkCardUpdate(CardUpdateDto dto) {
        if (!cardTopicRepository.existsById(dto.getTopicId())) {
            throw new ValidationException("Указанного топика не существует");
        }
        if (!cardTypeRepository.existsById(dto.getTypeId())) {
            throw new ValidationException("Указанного типа не существует");
        }
    }

    public void checkTempCardCreate(UserCardCreateDto dto) {
        if (dto.getTopicId() == null) {
            throw new ValidationException("Не указана тема карты");
        }
        // не имеет смысла, так как, в репозитории уже есть извлечение данных
        // и в случае ошибки будет проброшен EntityNotFoundException
//        if (!cardTypeRepository.existsById(dto.getTypeId())) {
//            throw new ValidationException("Не указан тип задания");
//        }
        if (cardRepository.existsByTask(dto.getTask())) {
            throw new ValidationException("Такое задание уже существует");
        }
        if (StringUtils.isNotEmpty(dto.getQuestion()) && cardRepository.existsByQuestion(dto.getQuestion())) {
            throw new ValidationException("Такое задание уже существует");
        }
    }
}
