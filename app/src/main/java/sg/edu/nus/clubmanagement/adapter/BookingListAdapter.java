package sg.edu.nus.clubmanagement.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import sg.edu.nus.clubmanagement.ClubFolder.Booking;
import sg.edu.nus.clubmanagement.R;

public class BookingListAdapter extends ArrayAdapter<Booking> {
  public BookingListAdapter(Context context) {
    super(context, R.layout.booking_row_layout);
  }
}
