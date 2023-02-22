package com.example.townmarket.common.domain.interest.repository;

import com.example.townmarket.common.domain.interest.dto.InterestPagingResponseDto;
import com.example.townmarket.common.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterestRepositoryQuery {

  boolean existsByUserIdAndProductId(Long userId, Long productId);

  Page<InterestPagingResponseDto> searchInterestIndexByUser(User user, Pageable pageable);
}
