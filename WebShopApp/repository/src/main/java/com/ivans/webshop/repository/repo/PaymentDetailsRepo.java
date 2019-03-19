package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetailsEntity, Integer> {

    List<PaymentDetailsEntity> findAllByAccountName(String accountName);

    List<PaymentDetailsEntity> findAllByAccountId(Integer accountId);

    List<PaymentDetailsEntity> findAllByCardNumber(String cardNumber);


}
