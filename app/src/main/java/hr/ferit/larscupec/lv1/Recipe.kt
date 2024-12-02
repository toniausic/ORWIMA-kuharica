package hr.ferit.larscupec.lv1

import androidx.annotation.DrawableRes

class Recipe(@DrawableRes val image: Int,
             val title: String,
             val category: String,
             val cookingTime: Int,
             val energy: Int,
             val rating: Float,
             val description: String,
             val reviews: List<String>,
             val ingredients: List<Ingredient>) {
}