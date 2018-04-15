package com.ShutdownTeam.ShutdownTeam.metier;

import com.ShutdownTeam.ShutdownTeam.dto.SearchDataDTO;
import com.ShutdownTeam.ShutdownTeam.entities.Produit;
import org.apache.commons.validator.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by amino on 14/04/2018
 */
@Service
public class ProduitMetierImpl implements ProduitMetier {

    public static final String GOOGLE_SEARCH_URL = "https://www.google.tn/search";

    @Override
    public List<SearchDataDTO> GetData(String SearchTearm,int num) throws IOException, KeyManagementException, NoSuchAlgorithmException {


        List<SearchDataDTO> searchsDataDTO = new ArrayList<>();
        String LinkHref = "";


        UrlValidator urlValidator = new UrlValidator();
        String searchURL = GOOGLE_SEARCH_URL+"?q="+  SearchTearm+"&num="+num+"&cr=countryTN";
        Document doc =  Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

        Elements results = doc.select("h3.r > a");
        for(Element result : results){
            SearchDataDTO searchDataDTO = new SearchDataDTO();

            LinkHref = result.attr("href");


            if(urlValidator.isValid(LinkHref.substring(LinkHref.indexOf("=")+1,LinkHref.length()-LinkHref.indexOf("=")+1))){
                searchDataDTO.setSearchURLIn(LinkHref.substring(LinkHref.indexOf("=")+1,LinkHref.length()-LinkHref.indexOf("=")+1));
                searchsDataDTO.add(searchDataDTO);
            }

        }


        return searchsDataDTO;
    }
}
