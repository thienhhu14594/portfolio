package com.thienhhu.backend.controller;

import com.thienhhu.backend.dto.request.ContactMessageRequestDto;
import com.thienhhu.backend.dto.response.ApiMessageResponseDto;
import com.thienhhu.backend.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    public ResponseEntity<ApiMessageResponseDto> createContactMessage(
            @Valid @RequestBody ContactMessageRequestDto request
    ) {
        contactMessageService.createContactMessage(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiMessageResponseDto("Message received. Thanks for reaching out!"));
    }
}

