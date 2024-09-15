package com.luv2code.jpbportal.controller;

import com.luv2code.jpbportal.entity.RecruiterProfile;
import com.luv2code.jpbportal.entity.Users;
import com.luv2code.jpbportal.repository.UsersRepository;
import com.luv2code.jpbportal.services.RecruiterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("recruiter-profile")
public class RecruiiterProfileController {

    private final UsersRepository usersRepository;
    private final RecruiterProfileService recruiterProfileService;

    @Autowired
    public RecruiiterProfileController(UsersRepository usersRepository,
                                       RecruiterProfileService recruiterProfileService) {
        this.usersRepository = usersRepository;
        this.recruiterProfileService = recruiterProfileService;
    }

    @GetMapping("/")
    public String recruiterProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Users users = usersRepository.findByEmail(currentUserName)
                    .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
            Optional<RecruiterProfile> recruiterProfile = recruiterProfileService.getOne(users.getUserId());

            if (!recruiterProfile.isEmpty()) {
                model.addAttribute("profile", recruiterProfile.get());
            }
        }

        return "recruiter_profile";
    }

}
