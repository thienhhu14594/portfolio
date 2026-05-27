package com.thienhhu.backend.service;

import com.thienhhu.backend.dto.request.ContactMessageRequestDto;
import com.thienhhu.backend.entity.ContactMessage;
import com.thienhhu.backend.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public void createContactMessage(ContactMessageRequestDto request) {
        ContactMessage entity = new ContactMessage();
        entity.setId(null);
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setMessage(request.message());
        contactMessageRepository.save(entity);
    }
}

