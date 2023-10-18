package com.okzampo.coffehour.mapper;

import com.okzampo.coffehour.dto.ResponseDTO;
import com.okzampo.coffehour.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseMapper<E extends BaseEntity, D> {
    public abstract D toDto(E entity);

    public abstract List<D> toDto(List<E> enities);

    public abstract E toEntity(D dto);

    public abstract List<E> toEntity(List<D> dtos);

    public ResponseDTO toResponse(E entity) {
        return ResponseDTO.builder().id(entity.getId()).className(entity.getClass().getSimpleName()).build();
    }

    public ResponseDTO toResponse(E entity, String msg) {
        return ResponseDTO.builder().id(entity.getId()).className(entity.getClass().getSimpleName()).message(msg).build();
    }

}
