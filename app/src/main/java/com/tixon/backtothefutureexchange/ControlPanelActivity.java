package com.tixon.backtothefutureexchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tixon.backtothefutureexchange.ui.ControlPanelItem;

public class ControlPanelActivity extends AppCompatActivity implements View.OnClickListener {

    private ControlPanelItem destinationTimePanel, presentTimePanel, lastTimeDepartedPanel;
    private Button bTravel;

    private int yearPresent, yearLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_panel_activity_layout);
        Intent fromMainActivity = getIntent();
        yearPresent = fromMainActivity.getIntExtra(Constants.KEY_YEAR_PRESENT, 2015);
        yearLast = fromMainActivity.getIntExtra(Constants.KEY_YEAR_LAST, 2015);
        initPanel();
    }

    private void initPanel() {
        destinationTimePanel = (ControlPanelItem) findViewById(R.id.destination_time_panel);
        presentTimePanel = (ControlPanelItem) findViewById(R.id.present_time_panel);
        lastTimeDepartedPanel = (ControlPanelItem) findViewById(R.id.last_time_departed_panel);

        bTravel = (Button) findViewById(R.id.control_panel_button_travel);
        bTravel.setOnClickListener(this);

        destinationTimePanel.setTextColor(ControlPanelItem.GREEN);
        presentTimePanel.setTextColor(ControlPanelItem.YELLOW);
        lastTimeDepartedPanel.setTextColor(ControlPanelItem.RED);

        presentTimePanel.setYear(yearPresent);
        lastTimeDepartedPanel.setYear(yearLast);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.control_panel_button_travel:
                Intent intent = new Intent();
                intent.putExtra(Constants.KEY_YEAR_DESTINATION, destinationTimePanel.getYear());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}