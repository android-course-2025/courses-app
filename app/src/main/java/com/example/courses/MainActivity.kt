package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {

            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.nameResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier.padding(
                    PaddingValues(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    )
                )
            ) {
                Text(
                    text = stringResource(topic.nameResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "decorative icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "${topic.numberAssociatedCourse}",
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TopicCardPreview() {
    TopicCard(
        Topic(
            R.string.architecture,
            58,
            R.drawable.architecture)
    )
}