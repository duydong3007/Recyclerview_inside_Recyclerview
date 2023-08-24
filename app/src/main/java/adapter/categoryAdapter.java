package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_inside_recyclerview.R;

import java.util.List;

import model.category;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.cateViewHolder> {
    private List<category> mCategoryList;

    public void setdatacate(List<category> list) {
     this.mCategoryList=list;
     notifyDataSetChanged();

    }

    @NonNull
    @Override
    public cateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);

        return new cateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cateViewHolder holder, int position) {

        category category=mCategoryList.get(position);
        if(category==null){
            return;
        }
        holder.imganh.setImageResource(category.getAnh());
    }

    @Override
    public int getItemCount() {
        if (mCategoryList!=null){
            return mCategoryList.size();
        }
        return 0;
    }

    public class cateViewHolder extends RecyclerView.ViewHolder{
        private ImageView imganh;
        public cateViewHolder(@NonNull View itemView) {
            super(itemView);
            imganh=(ImageView) itemView.findViewById(R.id.imganh);

        }
    }
}
