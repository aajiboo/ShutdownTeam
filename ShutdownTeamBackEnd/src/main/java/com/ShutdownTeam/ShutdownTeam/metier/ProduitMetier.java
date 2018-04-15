package com.ShutdownTeam.ShutdownTeam.metier;

import com.ShutdownTeam.ShutdownTeam.dto.SearchDataDTO;
import com.ShutdownTeam.ShutdownTeam.entities.Produit;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by amino on 14/04/2018
 */

public interface ProduitMetier {

    public List<SearchDataDTO> GetData(String SearchTearm,int num) throws IOException, KeyManagementException, NoSuchAlgorithmException;

}
