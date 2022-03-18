package com.luja93.composelazycolumntest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luja93.composelazycolumntest.theme.SquadTheme
import com.luja93.composelazycolumntest.squad.mapper.SquadMapper
import com.luja93.composelazycolumntest.squad.SquadScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapper = SquadMapper()

        setContent {
            SquadTheme {
                SquadScreen(items = mapper.map())
            }
        }
    }
}
