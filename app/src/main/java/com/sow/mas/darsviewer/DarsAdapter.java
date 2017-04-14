package com.sow.mas.darsviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sow.m on 2017/04/13.
 */

public class DarsAdapter extends ArrayAdapter<DarsModel> {

    LayoutInflater mLayoutInflater;

    public DarsAdapter(ArrayList<DarsModel> data, Context context) {
        super(context, R.layout.adapter_dars_list, data);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.adapter_dars_list, parent, false);
            holder.mTextDarsTitle = (TextView) convertView.findViewById(R.id.dars_title);
            holder.mTextDarsDate = (TextView) convertView.findViewById(R.id.dars_date);
            holder.mButtonOpen = (Button) convertView.findViewById(R.id.dars_button_open);
            holder.mButtonOpen.setOnClickListener(mOnButtonClick);
            holder.mButtonDelete = (Button) convertView.findViewById(R.id.dars_button_delete);
            holder.mButtonDelete.setOnClickListener(mOnButtonClick);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DarsModel data = getItem(position);
        holder.mButtonOpen.setTag(data.getFileName());
        holder.mTextDarsTitle.setText(data.getTitle());
        holder.mTextDarsDate.setText(data.getDate());

        return convertView;
    }

    View.OnClickListener mOnButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int id = view.getId();
            switch (id) {
                case R.id.dars_button_open:
                    // open file
                    String fileName = (String) view.getTag();
                    openFile(fileName);
                    break;

                case R.id.dars_button_delete:
                    // TODO Delete file
                    break;

                default:
                    break;
            }

        }
    };

    private class ViewHolder {
        TextView mTextDarsTitle;
        TextView mTextDarsDate;
        Button mButtonOpen;
        Button mButtonDelete;
    }

    private void openFile(String fileName) {
        String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        File file = new File(directory, fileName);
        if (!file.exists()) {
            Toast.makeText(getContext(), fileName + " doesn't exist!", Toast.LENGTH_LONG).show();
            return;
        }

        final Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open " + fileName);
        try {
            getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Could not open file!", Toast.LENGTH_LONG).show();
        }
    }
}
