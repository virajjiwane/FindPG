package com.example.viraj.finderpg;
/*
* It is a simple custom ArrayAdapter for HostelItem objects for custom ListView in TenantCityDetailsActivity
* After making changes in HostelItem make sure to reflect those changes here as well
* Refer hostel_list_item.xml resource file for layout of this
* */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class HostelAdapter extends ArrayAdapter<HostelItem> {

    private Context context;
    int resource;
    private List<HostelItem> hostelItemList;

    public HostelAdapter(@NonNull Context context, int resource, @NonNull List<HostelItem> hostelItemList) {
        super(context,resource,hostelItemList);
        this.context=context;
        this.resource=resource;
        this.hostelItemList=hostelItemList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource,parent,false);

        TextView hostelListItemName = (TextView) view.findViewById(R.id.hostelListItemName);
        TextView hostelListItemType = (TextView)view.findViewById(R.id.hostelListItemType);
        TextView hostelListItemPrice = (TextView)view.findViewById(R.id.hostelListItemPrice);
        TextView hostelListItemNoOfBeds =(TextView) view.findViewById(R.id.hostelListItemNoOfBeds);
        TextView hostelListItemAdress = (TextView)view.findViewById(R.id.hostelListItemAdress);

        HostelItem hostelItem = hostelItemList.get(position);

        hostelListItemName.setText(hostelItem.getName());
        hostelListItemType.setText("Type: "+hostelItem.getType());
        hostelListItemPrice.setText("Price: Rs "+hostelItem.getPrice());
        hostelListItemNoOfBeds.setText("No of beds: "+hostelItem.getNoOfBeds());
        hostelListItemAdress.setText(hostelItem.getAddr());

        return view;
    }


}
