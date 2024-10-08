package com.example.practice0819

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import com.example.practice0819.ui.theme.Practice0819Theme
import kotlin.random.Random
import androidx.compose.ui.unit.dp
import com.example.practice0819.ui.theme.Practice0819Theme


@Composable
fun Screen3() {
    // 画像リスト（アプリ内に保存されている画像のリソースIDをここに追加）
    val imageList = listOf(
        R.drawable.dtanaka_icon
        // さらに画像を追加
    )

    // 現在表示されている画像を保持するステート
    var currentImage by remember { mutableStateOf(imageList[0]) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = currentImage),
                contentDescription = "Random Image",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // ボタンがクリックされたときにランダムな画像を選択
                currentImage = imageList[Random.nextInt(imageList.size)]
            }) {
                Text(text = "ランダム画像表示")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    Practice0819Theme {
        Screen3()
    }
}