package com.itgroup.data.service.impl;

import com.itgroup.data.converter.CardTopicConverter;
import com.itgroup.model.dto.request.CardTopicCreateDto;
import com.itgroup.model.dto.request.CardTopicUpdateDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import com.itgroup.data.repository.dao.CardTopicRepository;
import com.itgroup.data.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
class CardTopicServiceImpl implements CommonService<CardTopicDto, CardTopicCreateDto, CardTopicUpdateDto> {

    private final CardTopicRepository repository;
    private final CardTopicConverter converter;

    @Override
    public CardTopicDto findById(UUID id) {
        return converter.convert(repository.findById(id));
    }

    @Override
    public List<CardTopicDto> findAll(String queryTail) {
        return converter.convert(repository.findAll(queryTail));
    }

    @Override
    public List<CardTopicDto> findAll(Collection<UUID> idList) {
        return converter.convert(repository.findAll(idList));
    }

    @Override
    public CardTopicDto create(CardTopicCreateDto dto) {
        return converter.convert(
                repository.create(
                        converter.convert(dto)
                )
        );
    }

    @Override
    public CardTopicDto update(CardTopicUpdateDto dto) {
        return converter.convert(
                repository.update(
                        converter.convert(dto)
                )
        );
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void remove(UUID id) {
        repository.remove(id);
    }
}
