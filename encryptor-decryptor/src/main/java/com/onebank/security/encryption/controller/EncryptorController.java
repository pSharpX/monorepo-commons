package com.onebank.security.encryption.controller;

import com.onebank.security.encryption.service.Encrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/security/encrypt")
@RequiredArgsConstructor
public class EncryptorController {

    private final Encrypt encryptService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void encryptContent(@RequestBody String request) throws IOException {
        encryptService.encryptSymmetric(request);
    }

}
