package com.example.demo.account;

import com.example.demo.account.dto.AccountPurchasesDto;
import com.example.demo.account.dto.PostAccountDto;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

//    @Mapping(source = "post.id", target = "postId")
//    @Mapping(source = "user.id", target = "userId")
//    ResponseAccountDto reactionToPostReactionDto(Account account);

//    @Mapping(source = "userId", target = "user.id")
//    @Mapping(source = "postId", target = "post.id")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    Account dtoToAccount(PostAccountDto postAccountDto);

    PostAccountDto accountToDto(Account account);
    AccountPurchasesDto accountToAccountPurchasesDto(Account account);
}
