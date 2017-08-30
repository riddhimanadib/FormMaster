package me.riddhimanadib.formmaster.model;

/**
 * Created by Nestor Islas on 30/08/2017.
 */

import java.util.List;

public class JSONFormElement {
    public int tag;
    public int type;
    public String title;
    public String value;
    public List<String> options;
    public String hint;
    public boolean required;
    public String alertTitle;
    public String positiveText;
    public String negativeText;
}
