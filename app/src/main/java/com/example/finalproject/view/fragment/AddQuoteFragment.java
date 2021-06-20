package com.example.finalproject.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.adapter.FavQsAdapter;
import com.example.finalproject.entity.AppDatabase;
import com.example.finalproject.entity.DataQuote;
import com.example.finalproject.view.database.MainAdapter;
import com.example.finalproject.view.database.MainContact;
import com.example.finalproject.view.database.MainPresenter;
import com.example.finalproject.view.viewModel.FavQsViewModel;

import java.util.List;

public class AddQuoteFragment extends Fragment implements MainContact.view {

    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;


    private Button btnSubmit;
    RecyclerView recyclerView;
    private EditText etInputQuote;

    private int id = 0;
    boolean edit = false;

    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_uname = "username";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSubmit = view.findViewById(R.id.submit);
        etInputQuote = view.findViewById(R.id.et_input_quote);
        recyclerView = view.findViewById(R.id.rv_add_quote);
        appDatabase = AppDatabase.inidb(getContext());
        mainPresenter = new MainPresenter(this);
        mainPresenter.readData(appDatabase);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void successAdd() {
        Toast.makeText(getContext(), "Berhasil nambahkan", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(getContext(), "Berhasil Menghapus", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etInputQuote.setText("");
    }

    @Override
    public void getData(List<DataQuote> list) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(list, this);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void editData(DataQuote item) {

    }

    @Override
    public void deleteData(DataQuote item) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Menghapus Data")
                .setMessage("Yakin mau dihapus?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        mainPresenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .show();
    }

    public AddQuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_quote, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            Log.d("nyobain", "onClick: yes");
            if (etInputQuote.getText().toString().equals("")) {
                Toast.makeText(getContext(), "Diisi dulu semua bos", Toast.LENGTH_SHORT).show();
            } else {
                if (!edit) {
                    sharedPreferences = this.getActivity().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
                    String name = sharedPreferences.getString(key_uname, null);
                    mainPresenter.insertData(etInputQuote.getText().toString(),
                            name,
                            appDatabase);
                }
                resetForm();
            }
        }
    }
}