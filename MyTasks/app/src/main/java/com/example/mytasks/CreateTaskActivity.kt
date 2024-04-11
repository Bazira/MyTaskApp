package com.example.mytasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytasks.databinding.ActivityCreateTaskBinding
import com.example.mytasks.databinding.ActivityMainBinding

class CreateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateTaskBinding
    private lateinit var db: TasksDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleSpace.text.toString()
            val content = binding.taskDescription.text.toString()
            val task = Task(0, title, content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Saved", Toast.LENGTH_SHORT).show()
        }
    }
}