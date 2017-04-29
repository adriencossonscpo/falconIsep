package com.falcon.avisep.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.avisep.repository.UserAvisRepository;

/**
 * REST controller for managing UserAvis.
 */
@Service
public class UserAvisService {

    @Autowired
    private UserAvisRepository userAvisRepository;


}
