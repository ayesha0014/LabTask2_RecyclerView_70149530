package com.example.labtask2_recyclerview_70149530;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CourseAdapter.OnItemClickListener {

    private ArrayList<Course> courses;
    private RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCourses = findViewById(R.id.rvCourses);

        courses = new ArrayList<>();
        courses.add(new Course("CS02310", "Mobile Application Development", "Dr. Ali Raza",
                "ali.raza@uol.edu.pk", "Building Android apps using Java, RecyclerView, Intents and more.", 3));
        courses.add(new Course("CS01210", "Software Requirement Engineering", "Ms. Sana Malik",
                "sana.malik@uol.edu.pk", "Eliciting, analysing and documenting software requirements.", 3));
        courses.add(new Course("CS01310", "Software Design and Architecture", "Dr. Usman Khan",
                "usman.khan@uol.edu.pk", "Design patterns, architectural styles and UML modelling.", 3));
        courses.add(new Course("CS01410", "Software Quality Assurance", "Ms. Hina Aslam",
                "hina.aslam@uol.edu.pk", "Testing techniques, quality standards and process improvement.", 3));
        courses.add(new Course("CS01510", "Database Systems", "Mr. Bilal Ahmad",
                "bilal.ahmad@uol.edu.pk", "Relational model, SQL, normalization and transactions.", 4));
        courses.add(new Course("CS01610", "Web Engineering", "Dr. Farah Naz",
                "farah.naz@uol.edu.pk", "Full-stack web development with modern frameworks.", 3));
        courses.add(new Course("CS01710", "Operating Systems", "Mr. Hassan Tariq",
                "hassan.tariq@uol.edu.pk", "Processes, threads, memory management and file systems.", 3));
        courses.add(new Course("CS01810", "Artificial Intelligence", "Dr. Sara Siddiqui",
                "sara.siddiqui@uol.edu.pk", "Search, knowledge representation and machine learning basics.", 3));

        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(new CourseAdapter(courses, this));
    }

    @Override
    public void onItemClick(int position) {
        Course course = courses.get(position);

        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(CourseDetailActivity.EXTRA_CODE, course.getCode());
        intent.putExtra(CourseDetailActivity.EXTRA_TITLE, course.getTitle());
        intent.putExtra(CourseDetailActivity.EXTRA_INSTRUCTOR, course.getInstructor());
        intent.putExtra(CourseDetailActivity.EXTRA_EMAIL, course.getEmail());
        intent.putExtra(CourseDetailActivity.EXTRA_DESCRIPTION, course.getDescription());
        intent.putExtra(CourseDetailActivity.EXTRA_CREDITS, course.getCreditHours());
        startActivity(intent);
    }
}