package com.febryan.listbuah;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {


    String [] namaBuah;
    int [] gambarBuah;
    int [] soundBuah;

    // 1. Buat Constractor
    public BuahAdapter(String[] namaBuah,int [] gambarBuah, int [] soundBuah){
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.soundBuah = soundBuah;
    }

    // 2. Call Layout
    @NonNull
    @Override
    public BuahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_row_buah, parent, false);
        return new MyViewHolder(view);
    }

    // 4. Tampilkan
    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.MyViewHolder holder, int position) {
        holder.imgBuah.setImageResource(gambarBuah[position]);
        holder.tvNamaBuah.setText(namaBuah[position]);

        //Agar bisa di klik
        Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Anda memilih "+namaBuah[position], Toast.LENGTH_SHORT).show();
            playSound(context, soundBuah[position]);
        });

    }

    // 5. Hitung banyaknya data
    @Override
    public int getItemCount() {
        return namaBuah.length;
    }

    // 3. Call Widget
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaBuah;
        ImageView imgBuah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBuah = itemView.findViewById(R.id.item_nama_buah);
            imgBuah = itemView.findViewById(R.id.item_image);
        }
    }

    private  void playSound(Context context, int soundBuah){
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri uri = Uri.parse("android.resource://" + getClass().getPackage().getName() + "/" + soundBuah);

        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
