import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//I know that we decided to use JavaFX for a GUI, I just wanted to connect the User class with
// something for testing purposes and see that variables are properly assigned

//public class SwingGUI extends JFrame {
//    public SwingGUI() {
//        // Set the title of the window
//        setTitle("Eazy-Peazy");
//
//        // Create a label with the text "Who's Eating?"
//        JLabel label = new JLabel("Who's Eating?");
//        // Set the font of the label
//        label.setFont(new Font("Century Gothic", Font.BOLD, 30));
//
//
//        // Set the alignment of the label to center
//        label.setHorizontalAlignment(JLabel.CENTER);
//        // Add the label to the content pane of the window
//        getContentPane().add(label, BorderLayout.NORTH);
//        
//        
//        ArrayList<User> users = User.DefaultUsers();
//        // Create buttons with the name of the users
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        
//        for(int i = 0; i < users.size(); i++) {
//        JButton button = new JButton("" + users.get(i).getUsername());
//        button.setFont(new Font("Century Gothic", Font.BOLD, 18));
//        button.setPreferredSize(new Dimension(80, 30));
//        buttonPanel.add(button);
//        
//        button.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		 // Get the text of the button
//                String username = button.getText();
//
//                // Display the info for the user with the matching username
//                User user = User.getUserByUsername(username);
//                
//                
//    
//                
//                
//                
//                // Assuming the User class has a getInfo() method that returns the user info as a String
//               JOptionPane.showMessageDialog(null, user.getInfo());
//        		
//        	}
//        });
//        }
//        
//        getContentPane().add(buttonPanel, BorderLayout.CENTER);
//        // Create a button to add a profile
//        JButton addButton = new JButton("Add Profile");
//        addButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
//        // Set the preferred size of the button
//        addButton.setPreferredSize(new Dimension(100, 30));
//
//        // Create a panel to hold the "Add Profile" button and set its layout
//        JPanel addProfilePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
//        // Add the "Add Profile" button to the panel
//        addProfilePanel.add(addButton);
//
//        // Add the panel to the content pane of the window in the BorderLayout.SOUTH position
//        getContentPane().add(addProfilePanel, BorderLayout.SOUTH);
//           
//
//        // Set the size of the window
//        setSize(450, 300);
//        // Set the window to be centered on the screen
//        setLocationRelativeTo(null);
//        // Set the default close operation of the window
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    
////    addButton.addActionListener(new ActionListener() {
////        public void actionPerformed(ActionEvent e) {
////            // Create a new window to add a profile
////            JFrame addProfileWindow = new JFrame("Add Profile");
////            // Set the size of the window
////            addProfileWindow.setSize(300, 150);
////            // Set the window to be centered on the screen
////            addProfileWindow.setLocationRelativeTo(null);
////
////            // Create a panel to hold the components and set its layout
////            JPanel addProfilePanel = new JPanel(new BorderLayout(10, 10));
////            // Create a label with the text "New Profile"
////            JLabel addProfileLabel = new JLabel("New Profile");
////            // Set the font of the label
////            addProfileLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
////            // Set the alignment of the label to center
////            addProfileLabel.setHorizontalAlignment(JLabel.CENTER);
////            // Add the label to the panel in the BorderLayout.NORTH position
////            addProfilePanel.add(addProfileLabel, BorderLayout.NORTH);
////
////            // Create a panel to hold the text field and set its layout
////            JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
////            // Create a label with the text "Username:"
////            JLabel usernameLabel = new JLabel("Username:");
////            usernameLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
////            // Add the label to the panel
////            textFieldPanel.add(usernameLabel);
////            // Create a text field with a default width of 20 characters
////            JTextField usernameTextField = new JTextField(20);
////            // Add the text field to the panel
////            textFieldPanel.add(usernameTextField);
////            // Add the panel to the addProfilePanel in the BorderLayout.CENTER position
////            addProfilePanel.add(textFieldPanel, BorderLayout.CENTER);
////
////            // Create a button to save the new profile
////            JButton saveButton = new JButton("Save");
////            saveButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
////            // Add an ActionListener to the button
////            saveButton.addActionListener(new ActionListener() {
////                public void actionPerformed(ActionEvent e) {
////                    // Get the text from the username text field
////                    String username = usernameTextField.getText();
////                    User.addUser(username);
////                  
////                    // Print the username to the console for testing purposes
////                    System.out.println("New username: " + username);
////                    // Close the addProfileWindow
////                    
////                    JButton button = new JButton(username);
////                    button.setPreferredSize(new Dimension(80, 30));
////                    buttonPanel.add(button);
////                    // Revalidate the panel to update the layout
////                    buttonPanel.revalidate();
////                    
////                
////                    addProfileWindow.dispose();
////                }
////            });
////            // Add the button to the addProfilePanel in the BorderLayout.SOUTH position
////            addProfilePanel.add(saveButton, BorderLayout.SOUTH);
////
////            // Add the addProfilePanel to the addProfileWindow's content pane
////            addProfileWindow.getContentPane().add(addProfilePanel);
////
////            // Set the window to be visible
////            addProfileWindow.setVisible(true);
////        }
////    });
////}
//
//    //public void startGUI () {
////    public static void main(String[] args) {
////        // Create an instance of the MyGUI class
////        SwingGUI gui = new SwingGUI();
////        // Show the window
////        gui.setVisible(true);
////    	}
////    
////      
////	}
//
