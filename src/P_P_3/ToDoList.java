package P_P_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import org.json.*;

public class ToDoList extends JFrame {
    private JList<Task> taskList;
    private DefaultListModel taskModel;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton completeButton;
    private JButton saveButton;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem saveMenuItem;
    private String filePath = "tasks.json";

    public ToDoList() {
        super("To-Do List");
        setLayout(new BorderLayout());

        taskModel = new DefaultListModel();
        taskList = new JList<Task>(taskModel);
        taskField = new JTextField();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");
        completeButton = new JButton("Complete");
        saveButton = new JButton("Save");
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        saveMenuItem = new JMenuItem("Save");

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
                    Task task = (Task) taskModel.get(selectedIndex);
                    String newTask = JOptionPane.showInputDialog(ToDoList.this, "Enter new task:", task.getTask());
                    if (newTask.isEmpty()) {
                        JOptionPane.showMessageDialog(ToDoList.this, "Task cannot be empty.");
                    } else if (taskModel.contains(new Task(newTask))) {
                        JOptionPane.showMessageDialog(ToDoList.this, "Task already exists in the list.");
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
                    Task task = (Task) taskModel.get(selectedIndex);
                    task.setCompleted(!task.isCompleted());
                    taskModel.set(selectedIndex, task);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTasksToFile();
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTasksToFile();
            }
        });

        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        taskPanel.add(taskField, BorderLayout.CENTER);
        taskPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(saveButton);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(taskPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loadTasksFromFile();
    }

    private void saveTasksToFile() {
        JSONArray taskArray = new JSONArray();
        for (int i = 0; i < taskModel.getSize(); i++) {
            Task task = (Task) taskModel.get(i);
            JSONObject taskObject = new JSONObject();
            taskObject.put("task", task.getTask());
            taskObject.put("completed", task.isCompleted());
            taskArray.put(taskObject);
        }
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(taskArray.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasksFromFile() {
        try (FileReader file = new FileReader(filePath)) {
            JSONArray taskArray = new JSONArray(new JSONTokener(file));
            for (int i = 0; i < taskArray.length(); i++) {
                JSONObject taskObject = taskArray.getJSONObject(i);
                String task = taskObject.getString("task");
                boolean completed = taskObject.getBoolean("completed");
                taskModel.addElement(new Task(task, completed));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}







