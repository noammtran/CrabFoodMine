package vn.edu.usth.crabfood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vn.edu.usth.crabfood.models.Menu;
import vn.edu.usth.crabfood.utils.MenuSanitizer;

public class ApiHelper {
    public static Menu menu = MenuSanitizer.sanitize(null).getMenu();
    public static final List<String> invalidImageUrls = Collections.synchronizedList(new ArrayList<>());

    private ApiHelper(){

    }
}
