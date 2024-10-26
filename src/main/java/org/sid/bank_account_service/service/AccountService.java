package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountRequesttDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO updateAccount(String id, BankAccountRequesttDTO bankAccountRequesttDTO);

    BankAccountResponseDTO addAccount(BankAccountRequesttDTO bankAccountRequesttDTO);
}
