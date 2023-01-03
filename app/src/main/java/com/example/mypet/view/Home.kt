package com.example.mypet.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypet.Model.Dog
import com.example.mypet.components.ItemDogCard
import com.example.mypet.components.TopBar

@Composable
fun Home(navController: NavController, dogList: List<Dog>, toggleTheme: () -> Unit) {
    LazyColumn{
        item{
            TopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(dogList){
            dogList.forEach {
                ItemDogCard(
                    it,
                    onItemClicked = { dog ->
                        navController.navigate("details/${dog.id}/${dog.name}/${dog.location}")
                    }
                )
            }
        }
    }
}
