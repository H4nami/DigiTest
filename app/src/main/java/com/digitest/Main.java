package com.digitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;



public class Main extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    int cont=0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent in = getIntent();
        final Bundle bundle = in.getExtras();


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state

                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                drawerLayout.closeDrawers();


                switch (menuItem.getItemId()){
                    //Replacing the main with the test activity
                    case R.id.test1:
                        Toast.makeText(getApplicationContext(),"Test1 Seleccionado",Toast.LENGTH_SHORT).show();
                        Intent nuevoForm = new Intent(Main.this,Test1.class);
                        EditText paciente = (EditText) findViewById(R.id.nombre);
                        nuevoForm.putExtra("nombrePac", paciente.getText().toString());
                        startActivity(nuevoForm);
                        return true;

                    case R.id.test2:
                        Toast.makeText(getApplicationContext(),"Test2 Seleccionado",Toast.LENGTH_SHORT).show();
                        Intent nuevoForm2 = new Intent(Main.this,Test2.class);
                        paciente = (EditText) findViewById(R.id.nombre);
                        nuevoForm2.putExtra("nombrePac", paciente.getText().toString());
                        startActivity(nuevoForm2);
                        return true;

                    case R.id.test3:
                        Toast.makeText(getApplicationContext(),"Test3 Seleccionado",Toast.LENGTH_SHORT).show();
                        Intent nuevoForm3 = new Intent(Main.this,Test3.class);
                        paciente = (EditText) findViewById(R.id.nombre);
                        nuevoForm3.putExtra("nombrePac", paciente.getText().toString());
                        startActivity(nuevoForm3);
                        return true;

                    /*case R.id.test4:
                        Toast.makeText(getApplicationContext(),"Test4 Seleccionado",Toast.LENGTH_SHORT).show();
                        Intent nuevoForm4 = new Intent(Main.this,Test1.class);
                        startActivity(nuevoForm4);
                        return true;*/

                    case R.id.email:
                        Toast.makeText(getApplicationContext(),"Correo enviado",Toast.LENGTH_SHORT).show();
                        menuItem.setChecked(false);
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        return true;

                    default:
                        EditText contra = (EditText)findViewById(R.id.contraseña);
                        String pass = contra.getText().toString();
                        if (pass.equals("admin")){
                            Toast.makeText(getApplicationContext(),"Usted ha ingresado",Toast.LENGTH_LONG).show();
                            menuItem.setChecked(false);

                            //Cambio de header
                            NavigationView item = (NavigationView) findViewById(R.id.navigation_view);
                            View child = getLayoutInflater().inflate(R.layout.header, null);
                            item.removeHeaderView(findViewById(R.id.header_login));
                            item.addHeaderView(child);

                            if (bundle != null){
                                final String nombrePac = bundle.getString("nombrePac");
                                EditText pacientenom = (EditText) findViewById(R.id.nombre);
                                pacientenom.setText(nombrePac);
                            }else{
                                Log.d("error","errorrrrrrrrrrrrr");
                            }


                            //cambio de menu
                            item.getMenu().setGroupVisible(R.id.grupoIngres,false);
                            item.getMenu().setGroupVisible(R.id.grupoTest, true);
                            item.getMenu().setGroupVisible(R.id.grupoMail,true);


                            return true;
                        }else {
                            Toast.makeText(getApplicationContext(),"contraseña incorrecta",Toast.LENGTH_SHORT).show();
                            menuItem.setChecked(false);
                            return false;
                        }


                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                if (cont==1) {
                    View textoinit = findViewById(R.id.textoEntrada);
                    ViewGroup parent = (ViewGroup) textoinit.getParent();
                    parent.removeView(textoinit);
                }cont++;
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
