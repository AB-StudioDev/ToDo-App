package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDo()
        }
    }
}
@Composable
fun ToDo(){
  var taskText by remember { mutableStateOf("") }
    var taskList by remember {
        mutableStateOf(listOf<String>())
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ){
        Column {
            Text(
                text = "To-Do List",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(30.dp))
            TextField(
                value = taskText,
                onValueChange = {taskText = it },
                modifier = Modifier.weight(1f),
                placeholder = {Text("Enter task")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    focusedContainerColor = Color.DarkGray,
                    cursorColor = Color.White,
                    focusedPlaceholderColor = Color.Gray
                )
            )
            Spacer(Modifier.width(10.dp))

            Button(onClick = {
                if(taskText.isNotBlank()){
                    taskList = taskList + taskText
                    taskText = ""
                }
            }) {
                Text(
                    text = "Add"
                )
            }
            Spacer(Modifier.height(20.dp))

            Column {
                taskList.forEach { task->
                    Text(
                        text = "➡️$task",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Spacer(Modifier.height(5.dp))

                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ToDoAppPreview() {
    ToDo()
}