package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountRequesttDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequesttDTO bankAccountRequesttDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createAcc(new Date())
                .balance(bankAccountRequesttDTO.getBalance())
                .type(bankAccountRequesttDTO.getType())
                .currency(bankAccountRequesttDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequesttDTO bankAccountRequesttDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAcc(new Date())
                .balance(bankAccountRequesttDTO.getBalance())
                .type(bankAccountRequesttDTO.getType())
                .currency(bankAccountRequesttDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
