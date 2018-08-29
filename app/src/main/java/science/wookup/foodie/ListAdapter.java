package science.wookup.foodie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    OnFoodClickListener onFoodClickListener;

    public ListAdapter(OnFoodClickListener onFoodClickListener) {
        this.onFoodClickListener = onFoodClickListener;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return Foods.names.length;
    }

    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView imageView;

        public ListHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            textView.setText(Foods.names[position]);
            imageView.setImageResource(Foods.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            onFoodClickListener.onFoodClick(getAdapterPosition());
        }
    }

    interface OnFoodClickListener {
        void onFoodClick(int position);
    }
}
