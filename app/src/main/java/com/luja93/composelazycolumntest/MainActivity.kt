package com.luja93.composelazycolumntest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luja93.composelazycolumntest.databinding.ActivityMainBinding
import com.luja93.composelazycolumntest.squad.SquadScreen
import com.luja93.composelazycolumntest.squad.mapper.SquadMapper
import com.luja93.composelazycolumntest.squad.rv.SquadAdapter
import com.luja93.composelazycolumntest.theme.SquadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapper = SquadMapper()

        // TODO: Uncomment for Compose versions of the project.
        setContent {
            SquadTheme {
                SquadScreen(items = mapper.map())
            }
        }

        // TODO: Uncomment for the View version of the project.
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val adapter = SquadAdapter()
//        binding.recyclerView.adapter = adapter
//
//        adapter.updateItems(mapper.map())
    }
}
