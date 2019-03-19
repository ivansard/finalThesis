package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, Integer> {

    List<PaymentEntity> findAllByPaidDate(Date paymentDate);

    List<PaymentEntity> findAllByPaidDateBetween(Date paidDateStart, Date paidDateEnd);

    PaymentEntity findByOrderId(Integer orderId);


}
