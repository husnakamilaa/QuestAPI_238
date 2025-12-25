package com.example.dataclass.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dataclass.uicontroller.route.DestinasiDetail
import com.example.dataclass.uicontroller.route.DestinasiEdit
import com.example.dataclass.uicontroller.route.DestinasiEntry
import com.example.dataclass.uicontroller.route.DestinasiHome
import com.example.dataclass.view.DetailSiswaScreen
import com.example.dataclass.view.EditSiswaScreen
import com.example.dataclass.view.EntrySiswaBody
import com.example.dataclass.view.EntrySiswaScreen
import com.example.dataclass.view.HomeScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier) {
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(DestinasiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate(("${DestinasiDetail.route}/${it}"))
                })
        }
        composable (DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.navigate(DestinasiHome
                .route)})
        }
        composable(route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateToEditItem ={navController.navigate("${DestinasiEdit.route}/$it")},
                navigateBack = {navController.navigate(DestinasiHome.route)}
            )
        }

    }
}