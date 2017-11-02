package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;

import me.riddhimanadib.formmaster.listener.FormItemEditTextListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Base ViewHolder method instance
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public interface BaseViewHolderInterface {
    FormItemEditTextListener getListener();
    void bind(int position, BaseFormElement formElement, Context context);
}
