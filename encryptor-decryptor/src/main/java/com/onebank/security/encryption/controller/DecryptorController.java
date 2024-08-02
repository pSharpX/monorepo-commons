package com.onebank.security.encryption.controller;

import com.onebank.security.encryption.service.Decrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/security/decrypt")
@RequiredArgsConstructor
public class DecryptorController {

    private final Decrypt decryptService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void decryptContent(@RequestBody byte[] request) throws IOException {
        decryptService.decryptSymmetric(request);
    }

}
