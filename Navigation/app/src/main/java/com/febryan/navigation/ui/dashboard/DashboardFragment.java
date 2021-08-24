package com.febryan.navigation.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.febryan.navigation.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);


        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        String [] namaHewan = {"Ayam", "Kodok", "Ular", "Gajah", "Kuda", "Kucing", "Zebra", "Tapir", "Ayam", "Kodok", "Ular", "Gajah", "Kuda", "Kucing", "Zebra", "Tapir"};

        final ListView listView = root.findViewById(R.id.list_view);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                namaHewan
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getActivity(), namaHewan[position], Toast.LENGTH_SHORT).show();
        });

        return root;

    }
}