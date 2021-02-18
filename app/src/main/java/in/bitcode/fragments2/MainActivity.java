package in.bitcode.fragments2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private LoginFragment mLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginFragment =
                (LoginFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.loginFragment);

        mLoginFragment.setOnLoginListener( new LoginFragmentListener() );
    }

    private class LoginFragmentListener implements LoginFragment.OnLoginListener{

        @Override
        public void onSuccess(LoginFragment loginFragment, String username) {

            HomeFragment homeFragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            homeFragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, homeFragment, null)
                    .addToBackStack(null)
                    .commit();

            //getSupportFragmentManager().popBackStack();
        }

        @Override
        public void onFailure(LoginFragment loginFragment, String username) {

        }
    }
}