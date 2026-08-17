package com.yourname.keystone.screens // Update with your actual package name

import com.keystone.components.PropertyCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourname.keystone.components.PropertyCard // Update with your package path

// Simple temporary data model for mocking the UI
data class PropertyItem(
    val id: String,
    val name: String,
    val address: String,
    val tenant: String,
    val status: String
)

@Composable
fun DashboardScreen() {
    // Temporary mock data to test the layout
    val sampleProperties = listOf(
        PropertyItem("1", "Sunset Heights #4B", "124 Beach Rd, Sea Point", "John Doe", "Occupied"),
        PropertyItem("2", "Greenwood Villa", "45 Oak Ave, Rondebosch", "Jane Smith", "Occupied"),
        PropertyItem("3", "The Urban Loft #12", "88 Long St, City Bowl", "None", "Vacant"),
        PropertyItem("4", "Harbour View Studio", "12 Dock Rd, Foreshore", "Mike Ross", "Maintenance")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)) // Subtle light background for light mode
            .padding(16.dp)
    ) {
        // --- Header ---
        Text(
            text = "Keystone Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E293B)
        )
        Text(
            text = "Portfolio Overview",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Summary Metric Cards ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SummaryMetricCard(
                title = "Total Units",
                value = "${sampleProperties.size}",
                modifier = Modifier.weight(1f)
            )
            SummaryMetricCard(
                title = "Occupied",
                value = "${sampleProperties.count { it.status == "Occupied" }}",
                modifier = Modifier.weight(1f)
            )
            SummaryMetricCard(
                title = "Vacant",
                value = "${sampleProperties.count { it.status == "Vacant" }}",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Recent Properties Section ---
        Text(
            text = "Active Properties",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1E293B)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleProperties) { property ->
                PropertyCard(
                    propertyName = property.name,
                    address = property.address,
                    tenantName = property.tenant,
                    status = property.status
                )
            }
        }
    }
}

@Composable
fun SummaryMetricCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
            )
        }
    }
}