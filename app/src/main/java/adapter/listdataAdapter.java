package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_inside_recyclerview.R;


import java.util.List;

import model.category;
import model.listdata;

public class listdataAdapter extends RecyclerView.Adapter<listdataAdapter.listdataViewHolDer> {

    private List<listdata> mListdata;
    private Context mContext;

    public static final int type_user=1;
    public static final int type_cate=2;

    public void setdata(Context mContext,List<listdata> listdata){
        this.mContext=mContext;
        this.mListdata=listdata;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return mListdata.get(position).getType();
    }

    @NonNull
    @Override
    public listdataViewHolDer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listdata,parent,false);
        return new listdataViewHolDer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listdataViewHolDer holder, int position) {

        listdata listdata=mListdata.get(position);
        if(listdata==null){
            return;
        }

        if(type_cate== holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
            holder.rcvlist.setLayoutManager(linearLayoutManager);

            categoryAdapter adapter=new categoryAdapter();
            adapter.setdatacate(listdata.getCategories());
            holder.rcvlist.setFocusable(false);
            holder.rcvlist.setAdapter(adapter);
            RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(mContext,DividerItemDecoration.HORIZONTAL);
            holder.rcvlist.addItemDecoration(itemDecoration);

        }
        else if(type_user== holder.getItemViewType()){

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
            holder.rcvlist.setLayoutManager(linearLayoutManager);

            useradapter useradapter=new useradapter();
            useradapter.setdata(listdata.getUsers());
            holder.rcvlist.setFocusable(false);
            holder.rcvlist.setAdapter(useradapter);
            RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
            holder.rcvlist.addItemDecoration(itemDecoration);

        }
    }

    @Override
    public int getItemCount() {
        if(mListdata!=null){
            return mListdata.size();
        }
        return 0;
    }

    public class listdataViewHolDer extends RecyclerView.ViewHolder{
        private RecyclerView rcvlist;
        public listdataViewHolDer(@NonNull View itemView) {
            super(itemView);
            rcvlist=(RecyclerView) itemView.findViewById(R.id.rcvlist);
        }
    }
}
