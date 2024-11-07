package com.itgroup.data.service.impl;

import com.itgroup.data.converter.CardTypeConverter;
import com.itgroup.model.dto.request.CardTypeCreateDto;
import com.itgroup.model.dto.request.CardTypeUpdateDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import com.itgroup.data.repository.dao.CardTypeRepository;
import com.itgroup.data.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CardTypeServiceImpl implements CommonService<CardTypeDto, CardTypeCreateDto, CardTypeUpdateDto> {

    private final CardTypeRepository repository;
    private final CardTypeConverter converter;

    @Override
    public CardTypeDto findById(UUID id) {
        return converter.convert(repository.findById(id));
    }

    @Override
    public List<CardTypeDto> findAll(String queryTail) {
        return converter.convert(repository.findAll(queryTail));
    }

    @Override
    public List<CardTypeDto> findAll(Collection<UUID> idList) {
        return converter.convert(repository.findAll(idList));
    }

    @Override
    public CardTypeDto create(CardTypeCreateDto dto) {
        return converter.convert(
                repository.create(
                        converter.convert(dto)
                )
        );
    }

    @Override
    public CardTypeDto update(CardTypeUpdateDto dto) {
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
