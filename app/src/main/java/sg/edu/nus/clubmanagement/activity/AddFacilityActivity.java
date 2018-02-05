package sg.edu.nus.clubmanagement.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

public class AddFacilityActivity extends AppCompatActivity {
  private EditText etFacilityName, etFacilityDescription;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_facility);

    etFacilityName = (EditText) findViewById(R.id.et_facility_name);
    etFacilityDescription = (EditText) findViewById(R.id.et_facility_description);


    Button btnSave = (Button) findViewById(R.id.btn_save);
    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (isValid()) {
          App.club.addFacility(etFacilityName.getText().toString().trim(),
                  etFacilityDescription.getText().toString().trim());
          Toast.makeText(AddFacilityActivity.this, getString(R.string.save_successful),
              Toast.LENGTH_SHORT).show();
          finish();
        }
      }
    });
  }

  private boolean isValid() {
    boolean isValid = true;
    if (TextUtils.isEmpty(etFacilityName.getText().toString().trim())) {
      etFacilityName.setError(getString(R.string.first_name_validation_msg));
      isValid = false;
    }
    if (TextUtils.isEmpty(etFacilityDescription.getText().toString().trim())) {
      etFacilityDescription.setError(getString(R.string.second_name_validation_msg));
      isValid = false;
    }

    return isValid;
  }
}
