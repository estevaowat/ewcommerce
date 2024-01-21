package com.ewcode.ewcomerce.infra.controller;

import com.ewcode.ewcomerce.application.usecase.RegisterProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final RegisterProductUseCase registerProductUseCase;

    @Autowired
    public ProductController(RegisterProductUseCase registerProductUseCase) {
        this.registerProductUseCase = registerProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> product(@RequestBody RegisterProductDTO product) {
        registerProductUseCase.execute(product);
        return ResponseEntity.ok().build();
    }

}
