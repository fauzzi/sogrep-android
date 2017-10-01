package com.skripsisogrep.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skripsisogrep.base.BaseAdapter;
import com.skripsisogrep.models.Optik;
import com.skripsisogrep.sogrep.R;

import butterknife.BindView;

/**
 * Created by Akhmad Fauzi Hasibuan on 9/30/2017
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */
public class MainAdapter extends BaseAdapter<Optik, MainAdapter.ViewHolder> {

    private onItemClickListener mListener;


    public interface onItemClickListener {
        void onSeeMoreClick(View view, Optik data);
    }

    public MainAdapter(onItemClickListener mListener){
        this.mListener = mListener;
    }

    @Override
    protected MainAdapter.ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(MainAdapter.ViewHolder holder) {
        final Optik data = getItem(holder.getAdapterPosition());

        holder.mName.setText(data.getName());
        holder.mAddress.setText(data.getAddress());
        holder.mOpenTime.setText(data.getOpen_time());
        holder.mCloseTime.setText(data.getClose_time());
        holder.mPhone.setText(data.getPhone());

        holder.mPicture.setImageResource(data.getPicture());

        holder.mSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onSeeMoreClick(view, data);
            }
        });

    }

    public class ViewHolder extends  BaseAdapter.BaseViewHolder {
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.address)
        TextView mAddress;
        @BindView(R.id.open_time)
        TextView mOpenTime;
        @BindView(R.id.close_time)
        TextView mCloseTime;
        @BindView(R.id.phone)
        TextView mPhone;
        @BindView(R.id.seeMore)
        TextView mSeeMore;
        @BindView(R.id.picture)
        ImageView mPicture;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
