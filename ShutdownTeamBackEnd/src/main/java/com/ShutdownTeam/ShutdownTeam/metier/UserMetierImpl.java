package com.ShutdownTeam.ShutdownTeam.metier;

import com.ShutdownTeam.ShutdownTeam.dao.UserRepository;
import com.ShutdownTeam.ShutdownTeam.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



/**
 * Created by amino on 19/06/2017
 */
@Service
public class UserMetierImpl implements UserMetier  {

    //--attributs
    @Autowired
    private PasswordEncoder passwordEncoder;
    //--attributs
    @Autowired
    private UserRepository userRepository;
    //--end attributs
    //--end attributs
}
