package NewP_P;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ToDoList extends JFrame {
    private JList<Task> taskList;
    private DefaultListModel<Task> taskModel;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton completeButton;

    public ToDoList() {
        super("To-Do List");
        setLayout(new BorderLayout());

        taskModel = new DefaultListModel<Task>();
        taskList = new JList<Task>(taskModel);
        taskField = new JTextField();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        completeButton = new JButton("Complete");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (task.isEmpty()) {
                    JOptionPane.showMessageDialog(ToDoList.this, "Please enter a task.");
                } else {
                    taskModel.addElement(new Task(task));
                    taskField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(ToDoList.this, "Please select a task to delete.");
                } else {
                    taskModel.remove(selectedIndex);
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(ToDoList.this, "Please select a task to edit.");
                } else {
                    Task task = taskModel.get(selectedIndex);
                    String newTask = JOptionPane.showInputDialog(ToDoList.this, "Enter new task:", task.getTask());
                    if (newTask.isEmpty()) {
                        JOptionPane.showMessageDialog(ToDoList.this, "Task cannot be empty.");
                    } else {
                        task.setTask(newTask);
                        taskModel.set(selectedIndex, task);
                    }
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(ToDoList.this, "Please select a task to mark as completed.");
                } else {
                    Task task = taskModel.get(selectedIndex);
                    task.setCompleted(!task.isCompleted());
                    taskModel.set(selectedIndex, task);
                }
            }
        });

        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        taskPanel.add(taskField, BorderLayout.CENTER);
        taskPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(completeButton);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(taskPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}


