package com.example.hookah.service;

import com.example.hookah.model.Admin;
import com.example.hookah.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean authority(Admin user) {
        Admin authorityUser = adminRepository.findByUsername(user.getUsername());
        if (authorityUser != null) {
            passwordEncoder.encode(user.getPassword()).equals(authorityUser.getPassword());
            return true;
        }
        return false;
    }

//    @Transactional
//    public boolean addUser(Admin user) {
//        if (adminRepository.findByUsername(user.getUsername()) == null) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            adminRepository.save(user);
//            return true;
//        }
//        return false;
//    }

//    @Transactional
//    public void removeUser(int id) {
//        adminRepository.deleteById(id);
//    }

}
