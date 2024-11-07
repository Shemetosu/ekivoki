package com.itgroup.data.service;

import com.itgroup.data.repository.dao.CardTypeRepository;
import com.itgroup.data.repository.dao.UserCardRepository;
import com.itgroup.data.util.StringUtils;
import com.itgroup.data.validation.CardValidator;
import com.itgroup.model.dto.request.UserCardCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCardService {

    private final UserCardRepository userCardRepository;
    private final CardTypeRepository cardTypeRepository;
    private final CardValidator cardValidator;

    public boolean createCard(UserCardCreateDto dto) {
        var topicId = dto.getTopicId() == null && StringUtils.isNotEmpty(dto.getTopicName())
                ? userCardRepository.createCardTopic(dto.getTopicName())
                : dto.getTopicId();
        dto.setTopicId(topicId);

        var cardType = cardTypeRepository.findById(dto.getTypeId());
        if (cardType.getDice() != 6) {
            dto.setDescription(null);
            dto.setQuestion(null);
        }

        cardValidator.checkTempCardCreate(dto);

        var id = userCardRepository.createCard(dto);
        return id != null;
    }
}
