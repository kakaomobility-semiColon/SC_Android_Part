package com.main.sc_android_part.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import com.kakao.vectormap.*
import com.main.sc_android_part.BuildConfig
import com.main.sc_android_part.R
import com.main.sc_android_part.view.search.SearchBar
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoMapSdk.init(this,BuildConfig.KAKAO_APP_KEY)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        var selectedIndex by remember { mutableStateOf(0) }
        val scope = rememberCoroutineScope()
        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberStandardBottomSheetState(
                initialValue = SheetValue.PartiallyExpanded // 초기 상태를 PartiallyExpanded로 설정
            )
        )

        // MapScreen as the main content
        Box(modifier = Modifier.fillMaxSize()) {
            MapScreen()
            SearchBar()

            // Bottom Navigation Bar
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(81.dp)
                    .zIndex(1f) // 바텀 네비게이션 바가 바텀 시트 위에 위치하도록 zIndex 설정
            ) {
                NavigationBar(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Color.White
                ) {
                    NavigationBarItem(
                        selected = selectedIndex == 0,
                        onClick = { selectedIndex = 0 },
                        label = { Text("주변") },
                        icon = { Icon(Icons.Default.Place, contentDescription = "주변 아이콘") }
                    )
                    NavigationBarItem(
                        selected = selectedIndex == 1,
                        onClick = { selectedIndex = 1 },
                        label = { Text("내 정보") },
                        icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "내 정보 아이콘") }
                    )
                    NavigationBarItem(
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2 },
                        label = { Text("북마크") },
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "북마크 아이콘") }
                    )
                }
            }

            // BottomSheetScaffold for the sheet
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 81.dp)
            ) {
                BottomSheetScaffold(
                    scaffoldState = bottomSheetScaffoldState,
                    sheetPeekHeight = 180.dp, // 바텀 시트가 처음부터 100dp만큼 보이게 설정
                    sheetContent = {
                        BottomSheetContent(sheetNumber = selectedIndex + 1)
                    },
                    content = {
                        Spacer(modifier = Modifier.height(0.dp)) // Empty content as MapScreen is outside
                    }
                )
            }
        }
    }

    @Composable
    fun BottomSheetContent(sheetNumber: Int) {
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

    @Composable
    fun MapScreen() {
        val context = LocalContext.current

        AndroidView(
            factory = { ctx ->
                val inflater = LayoutInflater.from(ctx)
                val view = inflater.inflate(R.layout.activity_main, null) as ViewGroup

                val mapView = view.findViewById<MapView>(R.id.map_view)

                mapView.start(object : MapLifeCycleCallback() {
                    override fun onMapDestroy() {
                        Log.d("success", "The Maps API has terminated normally.")
                    }

                    override fun onMapError(error: Exception) {
                        Log.d("fail", "Authentication failed or an error was detected while using the map")
                    }
                }, object : KakaoMapReadyCallback() {
                    override fun onMapReady(kakaoMap: KakaoMap) {
                        Log.d("success", "Map API call completed")
                    }

                    override fun getPosition(): LatLng {
                        return LatLng.from(37.406960, 127.115587)
                    }

                    override fun getZoomLevel(): Int {
                        return 15
                    }

                    override fun getViewName(): String {
                        return "Elecar"
                    }

                    override fun isVisible(): Boolean {
                        return true
                    }

                    override fun getTag(): String {
                        return "Elecar"
                    }
                })

                view
            },
            update = { /* 업데이트 로직 필요 시 추가 */ }
        )
    }
}
