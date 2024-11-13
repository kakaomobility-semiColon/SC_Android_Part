package com.main.sc_android_part.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.kakao.vectormap.*
import com.main.sc_android_part.BuildConfig
import com.main.sc_android_part.view.bottomsheet.BottomNavigationBar
import com.main.sc_android_part.view.bottomsheet.BottomSheetContent
import com.main.sc_android_part.view.map.MapScreen
import com.main.sc_android_part.view.search.SearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoMapSdk.init(this, BuildConfig.KAKAO_APP_KEY)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        MapScreen()
        SearchBar()

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(81.dp)
                .zIndex(1f)
        ) {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 81.dp)
        ) {
            BottomSheetScaffold(
                scaffoldState = bottomSheetScaffoldState,
                sheetContainerColor = Color.White,
                sheetShadowElevation = 16.dp,
                sheetPeekHeight = 180.dp,
                sheetContent = {
                    BottomSheetContent(sheetNumber = selectedIndex + 1)
                },
                content = {
                    Spacer(modifier = Modifier.height(0.dp))
                }
            )
        }
    }
}
