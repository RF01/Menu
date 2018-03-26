package app.sasoi_example.rf01.menus1;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private View dialogoView;
        private AlertDialog.Builder alertDialog ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      final  TextView view = (TextView)findViewById(R.id.edi_custom);

        alertDialog = new AlertDialog.Builder(this);
        dialogoView = getLayoutInflater().inflate(R.layout.custom, null);
        alertDialog.setView(dialogoView);
        alertDialog.setCancelable(false);

    final EditText editText = (EditText) dialogoView.findViewById(R.id.edi_custom);

    alertDialog.setPositiveButton(getString(R.string.accept), new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            view.setText(editText.getText().toString());

        }
    });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            //handle item selcetion
        switch(item.getItemId()){
            case R.id.id_mos_dialogo :
                if(dialogoView.getParent() != null){
                    ((ViewGroup) dialogoView.getParent()).removeView(dialogoView);

            }
            alertDialog.show();
                break;

            case R.id.m_cerrar:
                finish();
               //finishAndRemoveTask();
                break;

            case R.id.mRefresh:
                Toast.makeText(MainActivity.this, "Refresh", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }



}
