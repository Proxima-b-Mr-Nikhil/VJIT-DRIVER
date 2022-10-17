package com.nikhil.vjitdriver.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nikhil.vjitdriver.AllUsersAdapter;
import com.nikhil.vjitdriver.R;
import com.nikhil.vjitdriver.User;


public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    AllUsersAdapter useradapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        reference = FirebaseDatabase.getInstance().getReference("mainUsers");
        reference.keepSynced(true);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(reference, User.class)
                        .build();

        useradapter = new AllUsersAdapter(options);
        recyclerView.setAdapter(useradapter);

        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        useradapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        useradapter.startListening();
    }
}
