package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_inside_recyclerview.R;

import java.util.List;

import model.user;

public class useradapter extends RecyclerView.Adapter<useradapter.userViewHolder> {
    private List<user> mListUsers;

    public void setdata(List<user> list){
        this.mListUsers=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        user user=mListUsers.get(position);

        if(mListUsers==null){
            return;
        }
        holder.txtname.setText(user.getName());

    }

    @Override
    public int getItemCount() {
        if(mListUsers!=null){
            return mListUsers.size();
        }
        return 0;
    }

    public class userViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname;
        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=(TextView) itemView.findViewById(R.id.txtuser);

        }
    }
}
