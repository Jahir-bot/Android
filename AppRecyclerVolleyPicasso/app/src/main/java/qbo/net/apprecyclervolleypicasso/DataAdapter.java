package qbo.net.apprecyclervolleypicasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Data> datoss;

    public DataAdapter(Context context)
    {
        this.context = context;
        datoss =new ArrayList<>();
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_flor,parent,false);
        return new ViewHolder(view);
    }

    public void addData(ArrayList<Data> data)
    {
        datoss.clear();
        datoss.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        System.out.println("Longitud de DATOSSSS: "+datoss.size());
        final Data data = datoss.get(position);
        System.out.println("POSTID:  "+data.getPostId());
        System.out.println("ID:     "+data.getId());

        holder.tvtags.setText(data.getPostId().toString());
        holder.tvusuario.setText(data.getId().toString());

    }

    @Override
    public int getItemCount() {
        return datoss.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvusuario, tvtags;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtags = itemView.findViewById(R.id.tvtags);
            tvusuario = itemView.findViewById(R.id.tvusuario);
        }
    }
}
