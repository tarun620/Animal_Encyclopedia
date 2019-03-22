package com.example.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.animal_ticket.*

class animal_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle=intent.extras
        val name=bundle.getString("name")
        val des=bundle.getString("des")
        val image=bundle.getInt("image")

        animalimage.setImageResource(image)
        textname.setText(name)
        textdescription.setText(des)
    }
}
