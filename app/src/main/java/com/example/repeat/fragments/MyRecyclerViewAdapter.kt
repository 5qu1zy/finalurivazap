import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repeat.fragments.FoodFragment
import com.example.repeat.R
import com.squareup.picasso.Picasso

class MyRecyclerviewAdapter(var foods:List<FoodFragment>) :RecyclerView.Adapter<MyRecyclerviewAdapter.MyViewHolder>() {
    inner class MyViewHolder(V: View) : RecyclerView.ViewHolder(V){
        var viewfoods : FoodFragment?=null


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fragment_recyclerview_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myfood = foods[position]
        holder.viewfoods = myfood
        val nametext = holder.itemView.findViewById<TextView>(R.id.textView)
        nametext.text =myfood.name
        val image = holder.itemView.findViewById<ImageView>(R.id.imageView)
        Picasso.get().load(myfood.imageurl).into(image)
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}