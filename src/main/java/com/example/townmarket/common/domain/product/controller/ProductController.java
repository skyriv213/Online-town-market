package com.example.townmarket.common.domain.product.controller;

import static com.example.townmarket.common.domain.product.controller.ProductController.PRODUCT_URI_API;
import static com.example.townmarket.common.util.HttpResponseEntity.RESPONSE_CREATED;
import static com.example.townmarket.common.util.HttpResponseEntity.RESPONSE_DELETE;
import static com.example.townmarket.common.util.HttpResponseEntity.RESPONSE_OK;

import com.example.townmarket.common.domain.product.dto.PagingProductResponse;
import com.example.townmarket.common.domain.product.dto.ProductRequestDto;
import com.example.townmarket.common.domain.product.dto.ProductResponseDto;
import com.example.townmarket.common.domain.product.service.ProductService;
import com.example.townmarket.common.dto.PageDto;
import com.example.townmarket.common.dto.StatusResponse;
import com.example.townmarket.common.enums.ResponseMessages;
import com.example.townmarket.common.security.UserDetailsImpl;
import com.example.townmarket.common.util.SetHttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT_URI_API)
public class ProductController {

  public static final String PRODUCT_URI_API = "/products";

  private final ProductService productService;

  private final SetHttpHeaders httpHeaders;

  // 상품 생성
  @PostMapping
  public ResponseEntity<StatusResponse> addProduct(
      @RequestBody ProductRequestDto productRequestDto,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    productService.addProduct(userDetails.getUser(), productRequestDto);
    return RESPONSE_CREATED;
  }

  // 단일 상품 조회
  @GetMapping("/{productId}")
  public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long productId) {
    return ResponseEntity.ok().headers(httpHeaders.setHeaderTypeJson())
        .body(productService.getProduct(productId));
  }

  // 전체 상품 조회
//  @GetMapping
//  public ResponseEntity<Page<PagingProductResponse>> getProducts(@RequestBody PageDto pageDto) {
//    return ResponseEntity.ok()
//        .body(productService.getProducts(pageDto));
//  }
  @GetMapping
  public ResponseEntity<Page<PagingProductResponse>> getProducts(@RequestParam int page,
      @RequestParam int size) {
    return ResponseEntity.ok()
        .body(productService.getProducts(PageDto.builder().page(page).size(size).build()));
  }

  // 단일 상품 업데이트
  @PutMapping("/update/{productId}")
  public ResponseEntity<StatusResponse> updateProducts(@PathVariable Long productId,
      @RequestBody ProductRequestDto productRequestDto,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    productService.updateProduct(productId, productRequestDto, userDetails.getUser());
    return RESPONSE_OK;
  }

  // 단일 상품 삭제
  @DeleteMapping("/{productId}")
  public ResponseEntity<StatusResponse> deleteProduct(@PathVariable Long productId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    productService.deleteProduct(productId, userDetails.getUser());
    return RESPONSE_DELETE;
  }

}
