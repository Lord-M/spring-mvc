package com.example.demo.balanceUpdate;

import com.example.demo.balanceUpdate.dto.PostBalanceUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceUpdateMapper {
    BalanceUpdateMapper MAPPER = Mappers.getMapper(BalanceUpdateMapper.class);

    BalanceUpdate dtoToBalanceUpdate(PostBalanceUpdateDto postBalanceUpdateDto);

    PostBalanceUpdateDto balanceUpdateToDto(BalanceUpdate balanceUpdate);
}
