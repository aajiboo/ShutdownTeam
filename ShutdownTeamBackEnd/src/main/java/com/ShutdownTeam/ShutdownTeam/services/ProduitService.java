package com.ShutdownTeam.ShutdownTeam.services;

import com.ShutdownTeam.ShutdownTeam.dto.SearchDataDTO;
import com.ShutdownTeam.ShutdownTeam.entities.Produit;
import com.ShutdownTeam.ShutdownTeam.metier.ProduitMetier;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by amino on 14/04/2018
 */

@RestController
public class ProduitService {

    //--attributs
    @Autowired
    private ProduitMetier produitMetier;

    //--end attributs

    //--METHODES
    @RequestMapping(value = "/getData/{SearchTearm}/{num}",method = RequestMethod.GET)
    @CrossOrigin
    public int getCountProduit(@PathVariable String SearchTearm,@PathVariable int num) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        int i = 0;
        Document docIn = null;
        try {
            for (SearchDataDTO searchDataDTO : produitMetier.GetData(SearchTearm, num)) {

                org.jsoup.Connection con = Jsoup.connect(searchDataDTO.getSearchURLIn()).userAgent("Mozilla/5.0");
                con.timeout(180000).ignoreHttpErrors(true).followRedirects(true);


                docIn = con.get();

                Pattern p = Pattern.compile(SearchTearm);
                Matcher search = p.matcher(docIn.html());

                while (search.find()) {
                    i++;
                }
            }
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        catch (KeyManagementException e1){
            System.out.print(e1.getMessage());
        }
        catch(NoSuchAlgorithmException e2){
            System.out.print(e2.getMessage());
        }
        return i;
    }

}
