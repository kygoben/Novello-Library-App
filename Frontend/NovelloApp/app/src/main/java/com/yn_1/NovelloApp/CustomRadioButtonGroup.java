package com.yn_1.NovelloApp;

import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of radio button group,
 * which does not rely on the radio buttons
 * belonging to the same parent.
 *
 * @author Roba Abbajabal
 */
public class CustomRadioButtonGroup {
    private List<RadioButton> buttonCollection;

    public CustomRadioButtonGroup() {
        buttonCollection = new ArrayList<>();
    }

    public CustomRadioButtonGroup(List<RadioButton> buttons) {
        buttonCollection = buttons;
    }

    public void addButtonToGroup(RadioButton button) {
        button.setChecked(false);
        buttonCollection.add(button);
    }

    public List<RadioButton> getButtonCollection() {
        return buttonCollection;
    }

    public void radioButtonCheckChanged(RadioButton sender) {
        if (sender.isChecked())
        {
            for (RadioButton button : buttonCollection)
            {
                if (button != sender)
                {
                    button.setChecked(false);
                }
            }
        }
    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            radioButtonCheckChanged((RadioButton) v);
        }
    };
}
