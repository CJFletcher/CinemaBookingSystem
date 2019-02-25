package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import static controller.HelperClass.replaceSpacesInString;

public class FilmController {

    public static String downloadFilmInfo(String filmName, int filmYear) throws IOException {
        String apiKey = "3d4916dd";
        String filmNameNoSpaces = replaceSpacesInString(filmName);
        URL url = new URL("http://www.omdbapi.com/?t="+filmNameNoSpaces+"&y="+filmYear+"&apikey="+apiKey);
        String ret = "";
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            ret += new String(buffer, 0, count);
        }
        bis.close();
        return ret;
    }

}
