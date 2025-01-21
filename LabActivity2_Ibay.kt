import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class LabActivity2_Ibay : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_ibay)

        val chkScience = findViewById<CheckBox>(R.id.chk_science)
        val chkMath = findViewById<CheckBox>(R.id.chk_math)
        val chkFilipino = findViewById<CheckBox>(R.id.chk_filipino)
        val chkEnglish = findViewById<CheckBox>(R.id.chk_english)
        val chkHistory = findViewById<CheckBox>(R.id.chk_history)

        val btnEnroll = findViewById<Button>(R.id.btn_enroll)
        val outResult = findViewById<TextView>(R.id.out_result)
        val inpPayment = findViewById<EditText>(R.id.inp_payment)

        val courseCost = 5000

        btnEnroll.setOnClickListener() {
            val selectedCourses = mutableListOf<String>()

            if (chkScience.isChecked) selectedCourses.add("Science")
            if (chkMath.isChecked) selectedCourses.add("Math")
            if (chkFilipino.isChecked) selectedCourses.add("Filipino")
            if (chkEnglish.isChecked) selectedCourses.add("English")
            if (chkHistory.isChecked) selectedCourses.add("History")

            val selectedCount = selectedCourses.size

            if (selectedCount == 0) {
                outResult.text = "You must select at least 1 course!"
                return@setOnClickListener
            }
            if (selectedCount > 3) {
                outResult.text = "You can only enroll in up to 3 courses!"
                return@setOnClickListener
            }

            val totalCost = selectedCount * courseCost

            val payment = inpPayment.text.toString().toIntOrNull()
            if (payment == null || payment < totalCost) {
                outResult.text = "Insufficient payment! Total cost is $totalCost."
            } else {
                val change = payment - totalCost
                val enrolledCourses = selectedCourses.joinToString(", ")
                outResult.text = "Enrollment successful! \nCourses: $enrolledCourses \nChange: $change"
            }
        }
    }
}
