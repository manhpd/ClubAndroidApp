package sg.edu.nus.clubmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.clubmanagement.ClubFolder.Facility;
import sg.edu.nus.clubmanagement.ClubFolder.Member;
import sg.edu.nus.clubmanagement.R;
import sg.edu.nus.clubmanagement.application.App;

/**
 * Created by Swarna on 8/6/2016.
 */
public class FacilityListAdapter extends ArrayAdapter<Member> {
  private Context context;
  private List<Facility> facilities = new ArrayList<>();

  public FacilityListAdapter(Context context) {
    super(context, R.layout.mem_fac_row_layout);
    this.context = context;
    refreshFacilities();
  }

  @Override public View getView(final int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      LayoutInflater inflater =
          (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.mem_fac_row_layout, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
      viewHolder.btnRemove = (Button) convertView.findViewById(R.id.btn_remove);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    final Facility facility = facilities.get(position);
    viewHolder.tvName.setText(facility.toString());
    viewHolder.btnRemove.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        App.club.removeFacility(facility.getName());

      }
    });
    return convertView;
  }

  public void refreshFacilities() {
    facilities.clear();
    facilities.addAll(App.club.getFacilities());
    notifyDataSetChanged();
  }

  @Override public int getCount() {
    return facilities.size();
  }

  static class ViewHolder {
    TextView tvName;
    Button btnRemove;
  }
}
