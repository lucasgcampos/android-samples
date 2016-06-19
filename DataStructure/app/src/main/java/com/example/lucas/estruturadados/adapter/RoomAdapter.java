package com.example.lucas.estruturadados.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.estruturadados.R;
import com.example.lucas.estruturadados.activity.CategoryDetail;
import com.example.lucas.estruturadados.activity.MainActivity;
import com.example.lucas.estruturadados.model.Room;

import java.util.List;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private final List<Room> rooms;

    public RoomAdapter(List<Room> rooms) {
        this.rooms = rooms;
    }

    public RoomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Room room = rooms.get(position);
        holder.name.setText(room.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), CategoryDetail.class);
                intent.putParcelableArrayListExtra("subcategories", room.getSubCategories());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms != null ? rooms.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
