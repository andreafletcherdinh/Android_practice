package com.example.demo_constrain;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Khai báo các biến giao diện
    EditText enterA, enterB, result;
    Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ id cho các biến giao diện
        enterA = findViewById(R.id.enterA);
        enterB = findViewById(R.id.enterB);
        result = findViewById(R.id.result);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Xử lý tương tác người dùng
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ép từ kiểu string sang kiểu số nguyên
                int firstNumber = Integer.parseInt(enterA.getText().toString());
                int secondNumber = Integer.parseInt(enterB.getText().toString());
                int finalResult = firstNumber + secondNumber;
                result.setText(finalResult+""); // Đặt giá trị của kết quả vào ô textbox, cộng thêm chuỗi rỗng để tự biên dịch sang kiểu string

            }
        });
    }
}