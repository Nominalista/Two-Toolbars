package com.nominalista.twotoolbars;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Nominalista on 08/05/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.text_title);
    }
}
