@file:OptIn(ExperimentalMaterial3Api::class)

package hr.ferit.larscupec.lv1.ui

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.larscupec.lv1.R
import hr.ferit.larscupec.lv1.ui.theme.DarkGray
import hr.ferit.larscupec.lv1.ui.theme.DarkerGray
import hr.ferit.larscupec.lv1.ui.theme.Gray
import hr.ferit.larscupec.lv1.ui.theme.LightGray
import hr.ferit.larscupec.lv1.ui.theme.Pink
import hr.ferit.larscupec.lv1.ui.theme.Purple500
import hr.ferit.larscupec.lv1.ui.theme.White

@Preview(showBackground = true)
@Composable
fun RecipesScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenTitle(
            title = "What would you like to cook today?",
            subtitle = "Good morning, Lars"
        )
        SearchBar(
            iconResource = R.drawable.ic_search,
            labelText = "Search..."
        )
        RecipeCategories()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "7 recipes",
                fontSize = 14.sp,
                color = DarkerGray
            )
            Icon(
                painter = painterResource(R.drawable.ic_flame),
                contentDescription = "trending",
                modifier = Modifier.size(16.dp),
                tint = DarkerGray
            )
        }
        LazyRow {
            item {
                RecipeCard(
                    imageResource = R.drawable.strawberry_pie_1,
                    title = "Strawberry Pie"
                )
            }
            item {
                RecipeCard(
                    imageResource = R.drawable.strawberry_pie_1,
                    title = "Strawberry Pie"
                )
            }
        }
        IconButton(
            iconResource = R.drawable.ic_plus,
            text = "Add new recipe"
        )
    }
}

@Composable
fun ScreenTitle(
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = subtitle,
            style = TextStyle(
                color = Purple500,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic),
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.colors(
        unfocusedContainerColor = Color.Transparent,
        unfocusedPlaceholderColor = DarkGray,
        unfocusedTextColor = DarkGray,
        unfocusedLabelColor = DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    var searchInput by remember {
        mutableStateOf("")
    }
    TextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        label = {
            Text(labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(contentColor =
        White, containerColor = Pink) else
            ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor =
            LightGray),
        modifier = Modifier.fillMaxHeight(),
        onClick = { onClick() }
    ) {
        Text(text)
    }
}

@Composable
fun RecipeCategories() {
    var currentActiveButton by remember { mutableIntStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ) {
        TabButton(text = "All", isActive = currentActiveButton == 0) {
            currentActiveButton = 0
        }
        TabButton(text = "Breakfast", isActive = currentActiveButton == 1
        ){
            currentActiveButton = 1
        }
        TabButton("Lunch", currentActiveButton == 2) {
            currentActiveButton = 2
        }
    }
}

@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Pink),
    ) {
        Row {
            Icon(
                painter = painterResource(iconResource),
                contentDescription = text
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }
    }
}

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Purple500,
) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RecipeCard(
    @DrawableRes imageResource: Int,
    title: String
) {
    Box(
        Modifier
            .width(215.dp)
            .height(326.dp)
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Card(
            Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(imageResource),
                null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = title,
                color = White,
                fontWeight = FontWeight.Bold
            )
            Row {
                Chip(text = "30 min", textColor = Pink)
                Spacer(modifier = Modifier.width(8.dp))
                Chip(text = "4 ingredients", textColor = Pink)
            }
        }

    }
}