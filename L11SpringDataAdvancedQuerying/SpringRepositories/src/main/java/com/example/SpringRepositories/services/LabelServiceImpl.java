package com.example.SpringRepositories.services;

import com.example.SpringRepositories.repositories.LabelRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    private LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }
}
