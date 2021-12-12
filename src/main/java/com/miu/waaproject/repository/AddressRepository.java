package com.miu.waaproject.repository;

import com.miu.waaproject.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface AddressRepository extends JpaRepository<Address, Long> {
}
