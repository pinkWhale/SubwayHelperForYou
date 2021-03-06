package com.example.hyejung.easysubway.cellRow;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hyejung.easysubway.R;
import com.example.hyejung.easysubway.DBmodel.AppDataManager;

public class SubwayStationListRow {
    private View cell_View;
    private ImageView lineIcon;
    private Context mContext;
    private TextView titleView;

    public SubwayStationListRow(View cell) {
        this.cell_View = cell;
    }

    public void setCellData(Context context, Bundle bundle) {
        if (bundle != null) {
            this.mContext = context;
            getImageView().setImageResource(this.mContext.getResources().getIdentifier(AppDataManager.shared().getLineIconImage(Integer.parseInt(bundle.getString("lineCode"))), null, this.mContext.getPackageName()));
            getTitleView().setText(bundle.getString("stationName"));
        }
    }

    public TextView getTitleView() {
        if (this.titleView == null) {
            this.titleView = (TextView) this.cell_View.findViewById(R.id.titleView);
        }
        return this.titleView;
    }

    public ImageView getImageView() {
        if (this.lineIcon == null) {
            this.lineIcon = (ImageView) this.cell_View.findViewById(R.id.lineIcon);
        }
        return this.lineIcon;
    }
}
