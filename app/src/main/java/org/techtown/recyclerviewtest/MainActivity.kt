package org.techtown.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carList = mutableListOf<Car>()
        for (i in 0 ..100) {
            carList.add(Car("$i 번째 자동차 ", "$i 번째 엔진"))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL   , false)
        //recyclerView.layoutManager = GridLayoutManager(this,2)


    }
}

class RecyclerViewAdapter(
    var carList: MutableList<Car>,
    var inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        val nthCar : TextView
        val nthEngine : TextView

        init {
            nthCar = itemView.findViewById(R.id.nthCar)
            nthEngine = itemView.findViewById(R.id.nthEngine)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val car = carList.get(position)
                Log.d("testt",car.nthCar)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.car_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nthCar.text = carList.get(position).nthCar
        holder.nthEngine.text = carList.get(position).nthEngine
    }

    override fun getItemCount(): Int {
        return carList.size
    }

}

data class Car(val nthCar: String, val nthEngine : String)






























