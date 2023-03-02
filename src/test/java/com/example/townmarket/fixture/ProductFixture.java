package com.example.townmarket.fixture;

import static com.example.townmarket.fixture.UserFixture.USER1;

import com.example.townmarket.common.domain.product.dto.PagingProductResponse;
import com.example.townmarket.common.domain.product.dto.ProductRequestDto;
import com.example.townmarket.common.domain.product.dto.ProductResponseDto;
import com.example.townmarket.common.domain.product.entity.Product;
import com.example.townmarket.common.domain.product.entity.Product.ProductCategory;
import com.example.townmarket.common.domain.product.entity.Product.ProductEnum;
import com.example.townmarket.common.domain.product.entity.Product.ProductStatus;

public class ProductFixture {

  public static final Product PRODUCT = Product.builder()
      .productName("productName")
      .productPrice(1000L)
      .productStatus(ProductStatus.S)
      .productCategory(ProductCategory.CAR)
      .productEnum(ProductEnum.나눔)
      .user(USER1)
      .build();

  public static final ProductRequestDto PRODUCT_REQUEST_DTO = ProductRequestDto.builder()
      .productName("productName")
      .productPrice(1000)
      .productStatus(ProductStatus.S)
      .productCategory(ProductCategory.CAR)
      .productEnum(ProductEnum.나눔)
      .productContents("맥북팝니다")
      .build();

  public static final ProductResponseDto PRODUCT_RESPONSE_DTO = ProductResponseDto.builder()
      .productId(1L)
      .productName("productName")
      .productPrice(1000)
      .productStatus(ProductStatus.S)
      .productCategory(ProductCategory.CAR)
      .productEnum(ProductEnum.나눔)
      .productContents("맥북팝니다")
      .viewCount(1L)
      .nickName("nickname")
      .img("profileImg")
      .region("지역")
      .userGrade(5.0)
      .interest(1L)
      .build();

  public static final PagingProductResponse PAGING_PRODUCT_RESPONSE = PagingProductResponse.builder()
      .productId(1L)
      .productName("상품이름").productPrice(1000L).build();


  public static final Long PRODUCT_ID = 1L;
}
