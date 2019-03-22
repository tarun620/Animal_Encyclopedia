package com.example.zooapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    var listofanimal=ArrayList<animal>()
    var adapter:animaladapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listofanimal.add(animal("baboon","Baboons are mainly found in dry regions of Afica.",R.drawable.baboon,false))
        listofanimal.add(animal("bull dog","They are a medium-size dog with a thick-set, low-slung body. ",R.drawable.bulldog,false))
        listofanimal.add(animal("panda","Their thick, wooly coat helps to keep them warm in their cool mountain homes",R.drawable.panda,true))
        listofanimal.add(animal("swallow bird","Swallows are small, with pointed narrow wings, short bills, and small weak feet",R.drawable.swallow_bird,false))
        listofanimal.add(animal("white tiger","A Bengal tiger that is white in color because of a special gene that it has inherited from its parents.",R.drawable.white_tiger,true))
        listofanimal.add(animal("zebra","Zebras are several species of African equids united by their distinctive black-and-white striped coats.",R.drawable.zebra,false))

        adapter= animaladapter(this,listofanimal )
        listviewticket.adapter=adapter
    }


    class animaladapter:BaseAdapter
    {
        var listofanimal=ArrayList<animal>()
        var context:Context?=null
        constructor(context:Context,listofanimal: ArrayList<animal>):super()
        {
            this.listofanimal=listofanimal
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
        {
            var animal=listofanimal[position]
                if(animal.iskiller==true)
                {
                    val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val myview = inflator.inflate(R.layout.animal_killer_ticket, null)
                    myview.textname.text = animal.name!!
                    myview.textdescription.text = animal.des!!
                    myview.animalimage.setImageResource(animal.image!!)
                    myview.animalimage.setOnClickListener{

                        val intent=Intent(context,animal_info::class.java)
                        intent.putExtra("name",animal.name!!)
                        intent.putExtra("des",animal.des!!)
                        intent.putExtra("image",animal.image!!)
                        context!!.startActivity(intent)

                    }
                    return myview
                }
                else {
                    var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    var myview = inflator.inflate(R.layout.animal_ticket, null)
                    myview.textname.text = animal.name!!
                    myview.textdescription.text = animal.des!!
                    myview.animalimage.setImageResource(animal.image!!)
                    myview.animalimage.setOnClickListener {

                        val intent = Intent(context, animal_info::class.java)
                        intent.putExtra("name", animal.name!!)
                        intent.putExtra("des", animal.des!!)
                        intent.putExtra("image", animal.image!!)
                        context!!.startActivity(intent)

                    }
                    return myview
                }

        }

        override fun getItem(position: Int): Any
        {
            return listofanimal[position]
        }

        override fun getItemId(position: Int): Long
        {
            return position.toLong()
        }

        override fun getCount(): Int
        {
            return listofanimal.size
        }

    }
}

