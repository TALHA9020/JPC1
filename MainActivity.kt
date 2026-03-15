import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ایپ کا مین تھیم
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFDEEF4) // ہاؤس وائف ایپ کا مخصوص ہلکا گلابی رنگ
                ) {
                    SimpleCounter()
                }
            }
        }
    }
}

@Composable
fun SimpleCounter() {
    // یہ 'state' ہے جو یاد رکھے گی کہ گنتی کہاں تک پہنچی
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "آج کی گنتی",
            fontSize = 24.sp,
            color = Color.Black
        )
        
        Text(
            text = "$count",
            fontSize = 80.sp,
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0xFFE91E63) // گہرا گلابی رنگ
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63)),
            modifier = Modifier.size(width = 200.dp, height = 60.dp)
        ) {
            Text(text = "گنتی بڑھائیں (+)", fontSize = 18.sp)
        }

        TextButton(onClick = { count = 0 }) {
            Text(text = "دوبارہ شروع کریں (Reset)", color = Color.Gray)
        }
    }
}
