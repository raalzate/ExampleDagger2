package com.example.raalzate.exampledagger2.view;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raalzate.exampledagger2.R;
import com.example.raalzate.exampledagger2.model.RepositoryPOJO;

import java.util.ArrayList;
/**
 * Created by raul-alzate on 13/06/16.
 */
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private ArrayList<RepositoryPOJO> mRepositories;
    private Context mContext;
    private OnClickItemListener mOnClickItemListener;

    public RepositoryAdapter(Context context, OnClickItemListener onClickItemListener){
        setData(new ArrayList<RepositoryPOJO>());
        mContext = context;
        mOnClickItemListener = onClickItemListener;
    }

    public void setData(ArrayList<RepositoryPOJO> data){
        mRepositories = data;
    }

    public RepositoryPOJO getItemByPosition(int position){
        return mRepositories.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_item_repository, parent, false);
        return new ViewHolder(view, mOnClickItemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameView.setText(mRepositories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nameView;
        public OnClickItemListener onClickItemListener;
        public ViewHolder(View itemView, OnClickItemListener onListener) {
            super(itemView);
            nameView = (TextView)itemView.findViewById(R.id.name);
            onClickItemListener = onListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickItemListener.onClick(v, getAdapterPosition());
        }
    }

    public interface OnClickItemListener{
        void onClick(View view, int position);
    }
}
