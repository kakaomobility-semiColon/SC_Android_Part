package com.main.sc_android_part.view.bottomsheet

import android.graphics.drawable.Icon
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.sc_android_part.R

@Composable
fun BottomSheetContent(sheetNumber: Int) {
    if (sheetNumber == 2) {
        // 두 번째 시트 콘텐츠
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // 상단 버튼들
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Button(
                    modifier = Modifier.height(36.dp),
                    onClick = { /* TODO: 최근 목록 동작 */ },
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp, // 기본 상태의 elevation
                        pressedElevation = 12.dp // 눌렸을 때의 elevation
                    )
                ) {
                    Row(
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start // 왼쪽 정렬
                    ) {

                        Icon(
                            imageVector = Icons.Filled.History,
                            tint = Color.Black,
                            contentDescription = "최근 목록",
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "최근 목록",
                            fontSize = 14.sp,
                            color = Color.Black,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    modifier = Modifier.height(36.dp),
                    onClick = { /* TODO: 신규 장소 추가 동작 */ },
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp, // 기본 상태의 elevation
                        pressedElevation = 12.dp // 눌렸을 때의 elevation
                    )
                ) {
                    Row(
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start // 왼쪽 정렬
                    )
                    {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            tint = Color(0xFF007AFF),
                            contentDescription = "최근 목록",
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "신규 장소 추가",
                            fontSize = 14.sp,
                            color = Color(0xFF007AFF)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(45.dp))

            // 프로필 정보
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image), // 프로필 이미지 리소스 ID
                    contentDescription = "프로필 사진",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = "Samanda", // 사용자 이름
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            tint = Color.Gray,
                            contentDescription = "프로필 아이콘",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(top = 2.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "프로필 수정",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            imageVector = Icons.Default.Settings,
                            tint = Color.Gray,
                            contentDescription = "설정 아이콘",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(top = 2.dp)

                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "설정",
                            color = Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    } else {
        // 다른 시트의 콘텐츠
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Bottom Sheet $sheetNumber Content",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* TODO: 첫 번째 버튼 동작 */ }) {
                Text("Button 1")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* TODO: 두 번째 버튼 동작 */ }) {
                Text("Button 2")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* TODO: 세 번째 버튼 동작 */ }) {
                Text("Button 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    MaterialTheme {
        BottomSheetContent(sheetNumber = 2) // 두 번째 시트를 미리보기 위해 sheetNumber를 2로 설정
    }
}