package in.bitcode.fragments2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, null);

        mBtnLogin = view.findViewById(R.id.btnLogin);
        mEdtUsername = view.findViewById(R.id.edtUsername);
        mEdtPassword = view.findViewById(R.id.edtPassword);

        mBtnLogin.setOnClickListener(new BtnLoginClickListener());

        return view;
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {
                //way 1

                /*
                getFragmentManager()
                        .beginTransaction()
                        .remove(LoginFragment.this)
                        .commit();
                 */

                HomeFragment homeFragment = new HomeFragment();

                Bundle input = new Bundle();
                input.putString("username", mEdtUsername.getText().toString());
                homeFragment.setArguments(input);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.mainContainer, homeFragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}
