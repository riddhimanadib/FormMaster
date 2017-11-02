package me.riddhimanadib.formmaster.listener;

/**
 * Callback for if any data in form element list is changed
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public interface ReloadListener {
    void updateValue(int position, String updatedValue);
}
