package eu.tutorials.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView?  = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvSelectedDate = findViewById(R.id.showDate)
        val btnDatePicker : Button = findViewById(R.id.btnDatePicker) // connecting the variable to a specific id.
        btnDatePicker.setOnClickListener {
            clickDatePicker()

        }

    }
    fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val selectedDate =
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "year was $selectedYear, month was $selectedMonth, day was $selectedDayOfMonth", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedYear/${selectedMonth + 1}/$selectedDayOfMonth"
                tvSelectedDate?.setText(selectedDate)
            },
            year,
            month,
            day
            ).show()


    }
}