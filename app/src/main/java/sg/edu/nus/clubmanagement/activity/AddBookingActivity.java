package sg.edu.nus.clubmanagement.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import sg.edu.nus.clubmanagement.R;

public class AddBookingActivity extends AppCompatActivity {

  private Spinner spnMember, spnFacility;
  private EditText etDate, etStrtTime, etEndTime;
  private Button btnSave;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_booking);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    spnMember = (Spinner) findViewById(R.id.spn_member);
    spnFacility = (Spinner) findViewById(R.id.spn_facility);
    etDate = (EditText) findViewById(R.id.et_select_date);
    etStrtTime = (EditText) findViewById(R.id.et_select_strt_time);
    etEndTime = (EditText) findViewById(R.id.et_select_end_time);
    btnSave = (Button) findViewById(R.id.btn_save);

    Calendar dateCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    etDate.setText(dateFormatter.format(dateCalendar.getTime()));
    etDate.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        DatePickerDialog.OnDateSetListener onDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
              @Override
              public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
                etDate.setText(simpleDateFormat.format(calendar.getTime()));
              }
            };
        DatePickerDialog datePickerDialog =
            new DatePickerDialog(AddBookingActivity.this, onDateSetListener,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
      }
    });

    Calendar timeCalendar = Calendar.getInstance();
    SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
    etStrtTime.setText(timeFormatter.format(timeCalendar.getTime()));
    timeCalendar.add(Calendar.HOUR, 1);
    etEndTime.setText(timeFormatter.format(timeCalendar.getTime()));

    View.OnClickListener timeClickListener = new View.OnClickListener() {
      @Override public void onClick(final View v) {
        TimePickerDialog.OnTimeSetListener timeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
              @Override public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat timeFormatter =
                    new SimpleDateFormat("hh:mm a", Locale.getDefault());
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);
                EditText editText = (EditText) v;
                editText.setText(timeFormatter.format(calendar.getTime()));
              }
            };
        TimePickerDialog timePickerDialog =
            new TimePickerDialog(AddBookingActivity.this, timeSetListener,
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE), false);
        timePickerDialog.show();
      }
    };

    etStrtTime.setOnClickListener(timeClickListener);
    etEndTime.setOnClickListener(timeClickListener);
  }
}
