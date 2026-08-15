import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PropertyStatusBadge(status: String) {
    // Light backgrounds for the badge
    val backgroundColor = when (status.lowercase()) {
        "occupied" -> Color(0xFFE8F5E9) // Very Light Green
        "vacant" -> Color(0xFFFFEBEE)   // Very Light Red
        "maintenance" -> Color(0xFFFFF3E0) // Very Light Orange
        else -> MaterialTheme.colorScheme.secondaryContainer
    }

    // Darker text for contrast
    val textColor = when (status.lowercase()) {
        "occupied" -> Color(0xFF2E7D32) // Deep Green
        "vacant" -> Color(0xFFC62828)   // Deep Red
        "maintenance" -> Color(0xFFEF6C00) // Deep Orange
        else -> MaterialTheme.colorScheme.onSecondaryContainer
    }

    Text(
        text = status.uppercase(),
        color = textColor,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}