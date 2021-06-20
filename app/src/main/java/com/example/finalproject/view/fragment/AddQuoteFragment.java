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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddQuoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddQuoteFragment extends Fragment implements MainContact.view{

    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;


    private Button btnSubmit;
    private RecyclerView recyclerView;
    private EditText etInputQuote;

    private int id = 0;
    boolean edit = false;

    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_uname = "username";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSubmit = view.findViewById(R.id.submit);
        appDatabase = AppDatabase.inidb(getContext());
        mainPresenter = new MainPresenter(this);
        mainPresenter.readData(appDatabase);
        etInputQuote = view.findViewById(R.id.et_input_quote);
        recyclerView = view.findViewById(R.id.fragment_quote_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btnSubmit.setOnClickListener(this::onClick);
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
//        mainAdapter = new MainAdapter(getContext(),list,this);
//        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void editData(DataQuote item) {

    }

    @Override
    public void deleteData(DataQuote item) {
        AlertDialog.Builder builder;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        }
        else{
            builder = new AlertDialog.Builder(getContext());
        }
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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddQuoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddQuoteFragment newInstance(String param1, String param2) {
        AddQuoteFragment fragment = new AddQuoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_quote, container, false);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSubmit){
            Log.d("nyobain", "onClick: yes");
            if(etInputQuote.getText().toString().equals("")){
                Toast.makeText(getContext(), "Diisi dulu semua bos", Toast.LENGTH_SHORT).show();
            }
            else{
                if(!edit){
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