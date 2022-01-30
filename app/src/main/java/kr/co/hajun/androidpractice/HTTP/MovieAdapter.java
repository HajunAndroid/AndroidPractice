package kr.co.hajun.androidpractice.HTTP;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.co.hajun.androidpractice.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<DailyBoxOffice> items;

    public MovieAdapter(List<DailyBoxOffice> items){
        this.items = items;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        DailyBoxOffice item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView rank, movieNm, openDt;

        public ViewHolder(View itemView){
            super(itemView);
            rank = itemView.findViewById(R.id.rank);
            movieNm = itemView.findViewById(R.id.movieNM);
            openDt = itemView.findViewById(R.id.openDt);
        }

        public void setItem(DailyBoxOffice item){
            rank.setText(item.getRank());
            movieNm.setText(item.getMovieNm());
            openDt.setText(item.getOpenDt());
        }
    }
}
