package com.example.lucas.estruturadados.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.estruturadados.R;
import com.example.lucas.estruturadados.model.Room;

import java.util.List;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {

    private final List<Room> subCategories;

    public SubCategoryAdapter(List<Room> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubCategoryAdapter.ViewHolder holder, int position) {
        final Room sub = subCategories.get(position);
        holder.name.setText(sub.getName());
    }

    @Override
    public int getItemCount() {
        return subCategories != null ? subCategories.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
