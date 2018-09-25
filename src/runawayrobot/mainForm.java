/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runawayrobot;

//import com.sun.xml.internal.bind.v2.util.FatalAdapter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author phixuanhoan
 */
public class mainForm extends javax.swing.JFrame {
    //Biến lưu level từ txt
    private int level;
    // Biến lưu số phần tử của mảnh
    private int n;
    //Số ô tối thiểu của mảng
    private int kichThuocToiThieu = 4;
    //Số lượng level mà ta sẽ thay đổi kích thước 1 lần
    private int soLuongLevel = 3;
    //Mảng 2 chiều các button
    private JButton[][] Map;
    //Mảng 1 chiều danh sách các nước đi
    private JButton[] DanhSachNuocDi;
    //Kích thước bước đi
    public int sizeButtonBuocDi;
    //Số lượng nước đi được hiển thị
    private int soLuongNuocDi;
    //Kích thước Button
    private int sizeButton = 60;
    //Biến dem để chạy timer
    private int dem = 0;
    //Biến lưu vị trí phần tử của mảng 2 chiều
    private int viTriDongRobot = 0;
    private int viTriCotRobot = 0;
    //Timer
    private Timer time;
    
    /**
     * Creates new form mainForm
     */
    // Hàm trả về kiểu ImageIcon để add vào icon
    public ImageIcon getIconButton(String name, int width, int height){
        ImageIcon imageIcon = new ImageIcon("images/"+name+".png");
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    // Constractor Frame
    public mainForm() {
        initComponents();
        //Frame xuất hiện giữa
        this.setLocationRelativeTo(null);
        
        btnGo.setVisible(false);
        this.setSize(800, 800);
        
        ImageIcon imgQuaPhai = getIconButton("right", sizeButton,sizeButton);
        btnQuaPhai.setIcon(imgQuaPhai);
        
        ImageIcon imgXuong = getIconButton("down", sizeButton,sizeButton);
        btnXuongDuoi.setIcon(imgXuong);
        
        ImageIcon imgXoa = getIconButton("Delete", sizeButton,sizeButton);
        btnXoa.setIcon(imgXoa);
        
        ImageIcon imgGo = getIconButton("go", sizeButton,sizeButton);
        btnGo.setIcon(imgGo);
        File file = new File("level.txt");
            if(file.exists()){
                try {
                    String s = "";
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream("level.txt")));
                    while (stdin.ready()) {
                        s = stdin.readLine();
                    }
                   txtLevel.setText(s);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Tồn tain tập tin nhưng không đọc được !");
                }
            }else{
                txtLevel.setText("1");
            }
            
        TaoMapMoi();
        btnGo.setToolTipText("Click để bắt đầu chạy");
        btnQuaPhai.setToolTipText("Click để thêm một bước sang phải");
        btnXuongDuoi.setToolTipText("Click để thêm một bước xuống dưới");
        btnTaoMap.setToolTipText("Click để tạo bản đồ mới");
        btnXoa.setToolTipText("Click để xoá một bước đi");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTaomap = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        btnTaoMap = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        btnQuaPhai = new javax.swing.JButton();
        btnXuongDuoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGo = new javax.swing.JButton();
        lblLevel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Runaway Robot");
        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(252, 229, 231));

        lblTaomap.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblTaomap.setText("Nhập vào level");

        txtLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLevelKeyPressed(evt);
            }
        });

        btnTaoMap.setBackground(new java.awt.Color(255, 255, 255));
        btnTaoMap.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        btnTaoMap.setText("Tạo Map");
        btnTaoMap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMapActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(252, 229, 231));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        btnQuaPhai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuaPhai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuaPhaiActionPerformed(evt);
            }
        });

        btnXuongDuoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuongDuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuongDuoiActionPerformed(evt);
            }
        });

        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        lblLevel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuaPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnXuongDuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTaomap, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoMap)
                .addGap(27, 27, 27))
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTaomap)
                        .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTaoMap)
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnQuaPhai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuongDuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void TaoMapMoi(){
        try {
            //Cho khởi tạo lại nút nhất
            btnGo.setEnabled(true);
            btnQuaPhai.setEnabled(true);
            btnXuongDuoi.setEnabled(true);
            btnXoa.setEnabled(true);
            //Lấy dữ liệu từ textBox
            level = Integer.parseInt(txtLevel.getText());
            //Đọc file
            int level_ThucSu = 1;
            File file = new File("level.txt");
            if(file.exists()){
                try {
                    String s = "";
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream("level.txt")));
                    while (stdin.ready()) {
                        s = stdin.readLine();
                    }
                    level_ThucSu = Integer.parseInt(s);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Tồn tain tập tin nhưng không đọc được !");
                }
            }
            //Kiểm tra level hiện tại và level trên file
            boolean flag = true;
            if(level > level_ThucSu){
                JOptionPane.showMessageDialog(null, "Không thể đi lên level này");
                level = level_ThucSu;
                txtLevel.setText("" + level);
                flag = false;
            }
            if(flag == true){
            lblLevel.setText("Level: "  + txtLevel.getText());
            txtLevel.setText(level_ThucSu + "");
            n = (level - 1)/soLuongLevel + kichThuocToiThieu;
            //Khi tạo map mới thì xoá hết trên panel
            panel.removeAll();
            dem = 0;
            viTriDongRobot = 0;
            viTriCotRobot = 0;
            this.setSize(801, 801);
            Map = new JButton[n][n];
            int kichThuoc = 600;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    Map[i][j] = new JButton();
                    Map[i][j].setName("map");
                    Map[i][j].setSize(kichThuoc/n, kichThuoc/n);
                    Map[i][j].setLocation(j*Map[i][j].getWidth(), i*Map[i][j].getHeight() + 100);
                    Map[i][j].setFocusPainted(false);
                    Map[i][j].setBorder(new LineBorder(Color.BLACK));
                    //Kiểm tra có phải button ở đích đến hay không(dòng cuối, cột cuối)
                    if( i == n -1 || j == n - 1){
                        Map[i][j].setBackground(Color.BLUE);
                    }
                    panel.add(Map[i][j]);
                    this.setSize(800, 800);
                }
            }
            //Hiển thị Robot lên Map
            ImageIcon imageRobot = new ImageIcon("images/robot.png");
            Image imgRB = imageRobot.getImage();
            Image newImgRB = imgRB.getScaledInstance(Map[0][0].getWidth(), Map[0][0].getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageRB = new ImageIcon(newImgRB);
            Map[0][0].setIcon(imageRB);
            
            //Hiển trị chướng ngại vật
            //Bước 2: tính số lượng 
            Random rand = new Random();
            int min = (int)((n*n - 2 *n)*(0.15));
            int max = (int)((n*n - 2 *n)*(0.2) + 1);
            int  SoLuongBom = rand.nextInt(max - min) + min; 
            
            //Bước 2: cho bom hiển thị theo đúng quy tắc
            for(int  i = 0; i < SoLuongBom; i++){
                int viTriDong_ChuongNgaiVat;
                int viTriCot_ChuongNgaivat;
                do {                    
                    viTriCot_ChuongNgaivat = rand.nextInt(n-1);
                    viTriDong_ChuongNgaiVat = rand.nextInt(n-1);
                } while (Map[viTriDong_ChuongNgaiVat][viTriCot_ChuongNgaivat].getIcon() != null); // Bom khác vị trí Robot
                /**
                 * Bom không được trùng lên nhau
                 * Cách 2: Mỗi lần random ra xem chỗ đó có Bom chưa
                 */
               
                ImageIcon imageIconBOM = new ImageIcon("images/boom.png");
                Image imgBOM = imageIconBOM.getImage();
                Image newImgBOM = imgBOM.getScaledInstance(Map[0][0].getWidth(), Map[0][0].getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageBOM = new ImageIcon(newImgBOM);
                Map[viTriDong_ChuongNgaiVat][viTriCot_ChuongNgaivat].setIcon(imageBOM);  
            }
            //Hiển thị nước đi cho phép
            //Bước 1: tính tổng số nước đi dựa trên n
            int maxNuocDi = (int)(0.75 * n) + 1;
            int minNuocDi = (int)(0.5 * n);
            soLuongNuocDi = rand.nextInt(maxNuocDi - minNuocDi) + minNuocDi;
            //Bước 2: button nước đi
            DanhSachNuocDi = new JButton[soLuongNuocDi];
            sizeButtonBuocDi = 60;
            if(soLuongNuocDi > this.getWidth()/sizeButtonBuocDi){
                sizeButtonBuocDi  = (this.getWidth() - 60)/soLuongNuocDi;
            }
            for(int i = 0; i <soLuongNuocDi; i++){
                DanhSachNuocDi[i] = new JButton();
                DanhSachNuocDi[i].setSize(sizeButtonBuocDi,sizeButtonBuocDi);
                DanhSachNuocDi[i].setLocation(i*DanhSachNuocDi[i].getWidth(), Map[0][0].getLocation().y - DanhSachNuocDi[i].getHeight() - 5);
                this.setSize(801, 801);
                panel.add(DanhSachNuocDi[i]);
                //Nếu bước đi lớn hơn số bước đi trên 2 thì bắt đầu cho "GO"
                if( i >= soLuongNuocDi / 2 ) {
                    DanhSachNuocDi[i].setText("GO");
                }
            }
            // Button LOOP chỉ hiển thị ra để cho người dùng biến là nó lặp lại
            JButton btnLoop = new JButton();
            btnLoop.setSize(sizeButtonBuocDi -10, sizeButtonBuocDi -10);
            // sizeButtonBuocDi*soLuongNuocDi, 
            btnLoop.setLocation(sizeButtonBuocDi*soLuongNuocDi,Map[0][0].getLocation().y - sizeButtonBuocDi - 5);
            ImageIcon loop = getIconButton("loop", sizeButtonBuocDi - 10, sizeButtonBuocDi -10);
            btnLoop.setContentAreaFilled(false); //bỏ button bao bên ngoài
            btnLoop.setIcon(loop);  //set icon
            panel.add(btnLoop);
            this.setSize(800, 800); //giúp nó hiển thị lên
            }
            
            
        } catch (Exception e) {
            txtLevel.setText("");
            JOptionPane.showMessageDialog(null, "Dữ liệu phải ở dạng số");
        }
    }
    private void btnTaoMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMapActionPerformed
        TaoMapMoi();
    }//GEN-LAST:event_btnTaoMapActionPerformed
    public void HienThiMuiTenTrenDanhSachNuocDi(String type, String img){
        for(int i = 0; i <soLuongNuocDi; i++){
            if(DanhSachNuocDi[i].getIcon() == null){
                ImageIcon imgDown = getIconButton(img, sizeButtonBuocDi, sizeButtonBuocDi);
                DanhSachNuocDi[i].setIcon(imgDown);
                DanhSachNuocDi[i].setName(type);
                if(DanhSachNuocDi[soLuongNuocDi/2].getIcon() != null){
                    btnGo.setVisible(true);
                }
                break;
            }
        }
    }
    private void btnXuongDuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuongDuoiActionPerformed
         HienThiMuiTenTrenDanhSachNuocDi("xuong", "down");
    }//GEN-LAST:event_btnXuongDuoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        for(int i = soLuongNuocDi -1; i >=0; i--){
            if(DanhSachNuocDi[i].getIcon() != null){
                DanhSachNuocDi[i].setIcon(null);
                DanhSachNuocDi[i].setName("");
                if(DanhSachNuocDi[soLuongNuocDi/2].getIcon() == null){
                    btnGo.setVisible(false);
                }
                break;
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    // Kiểm tra thắng thua
    public void CheckWinLose(){
        for(JButton b : DanhSachNuocDi ){
            b.setBackground(Color.lightGray);
        }
        if((DanhSachNuocDi[dem].getName().equals("xuong") || DanhSachNuocDi[dem].getName().equals("phai")) ){
             if(dem == 0){
                 Map[viTriDongRobot][viTriCotRobot].setBackground(Color.red);
             }else{
                 if(viTriCotRobot != n -1 && viTriDongRobot != n-1){
                    Map[viTriDongRobot][viTriCotRobot].setBackground(Color.yellow);
                }
             }
         }
        //========================================================
        if(viTriCotRobot == n - 1 || viTriDongRobot == n - 1){
            time.stop();
            int Width =  Map[viTriDongRobot][viTriCotRobot].getWidth();
            Map[viTriDongRobot][viTriCotRobot].setIcon(getIconButton("robot", Width, Width));
            JOptionPane.showMessageDialog(null, "Bạn đã chiến thắng!");

            
            //Vô hiệu hoá nút nhấn
            btnGo.setEnabled(false);
            btnQuaPhai.setEnabled(false);
            btnXuongDuoi.setEnabled(false);
            btnXoa.setEnabled(false);
            btnGo.setVisible(false);
            //Khi thăng thì gọi lại hàm
            level= level+1;
            txtLevel.setText(level+"");
            int level_ThucSu = 1;
            File file1 = new File("level.txt");
            if(file1.exists()){
                try {
                    String text = "";
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream("level.txt")));
                    while (stdin.ready()) {
                        text = stdin.readLine();
                    }
                    level_ThucSu = Integer.parseInt(text);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Tồn tại tập tin nhưng không đọc được !");
                }
            }
            try {
                FileOutputStream file = new FileOutputStream("level.txt");
                DataOutputStream data = new DataOutputStream(file);
                if(level > level_ThucSu){
                    data.writeBytes(txtLevel.getText());
                }else{
                    data.writeBytes(level_ThucSu+"");
                }
                file.close();
                data.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            }
            TaoMapMoi();
        }else if(Map[viTriDongRobot][viTriCotRobot].getIcon()  != null){ //đụng boom
            time.stop();
            int Width =  Map[viTriDongRobot][viTriCotRobot].getWidth();
            Map[viTriDongRobot][viTriCotRobot].setIcon(getIconButton("bigbang", Width, Width));
            JOptionPane.showMessageDialog(null, "Bạn đã thua !");
            btnGo.setEnabled(false);
            btnQuaPhai.setEnabled(false);
            btnXuongDuoi.setEnabled(false);
            btnXoa.setEnabled(false);
            //Trả lại bom
             Map[viTriDongRobot][viTriCotRobot].setIcon(getIconButton("boom", Width, Width));
            //Cho robot về 0,0
            viTriCotRobot = viTriDongRobot = 0;
            Map[viTriDongRobot][viTriCotRobot].setIcon(getIconButton("robot", Width, Width));
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    Map[i][j].setBackground(Color.lightGray);
                    if(i == n -1 || j == n - 1){
                        Map[i][j].setBackground(Color.blue);
                    }
                }
            }
            for(int i = 0; i < soLuongNuocDi; i++){
                DanhSachNuocDi[i].setName("");
                DanhSachNuocDi[i].setIcon(null);
                DanhSachNuocDi[i].setBackground(Color.lightGray);
            }
            dem = 0;
            btnGo.setEnabled(true);
            btnQuaPhai.setEnabled(true);
            btnXuongDuoi.setEnabled(true);
            btnXoa.setEnabled(true);
            btnGo.setVisible(false);
         }else{
            int Width =  Map[viTriDongRobot][viTriCotRobot].getWidth();
            Map[viTriDongRobot][viTriCotRobot].setIcon(getIconButton("robot", Width, Width));
        }
       //======================================================================
    }
    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
       time = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiChuyen();
            }
        });
        time.start();
    }//GEN-LAST:event_btnGoActionPerformed
    
    private void btnQuaPhaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuaPhaiActionPerformed
         //Bấm vào đây kiểm tra trống ở đâu thì thêm vào đó
         HienThiMuiTenTrenDanhSachNuocDi("phai", "right");
    }//GEN-LAST:event_btnQuaPhaiActionPerformed

    private void txtLevelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLevelKeyPressed
         // Nhấn enter thì bắt đầu đến level mong muôn
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            TaoMapMoi();
            //cho con trỏ chuột nằm đúng chỗ textbox
            txtLevel.requestFocus();
            txtLevel.setSelectionStart(0);
            txtLevel.setSelectionEnd(txtLevel.getText().length());
        }
    }//GEN-LAST:event_txtLevelKeyPressed

    public void DiChuyen(){
         for(JButton b : DanhSachNuocDi ){
            b.setBackground(Color.lightGray);
        }
        DanhSachNuocDi[dem].setBackground(Color.yellow);
        //Tô màu đừng đi
        if((DanhSachNuocDi[dem].getName().equals("xuong") || DanhSachNuocDi[dem].getName().equals("phai")) ){
             if(dem == 0){
                 Map[viTriDongRobot][viTriCotRobot].setBackground(Color.red);
             }else{
                 if(viTriCotRobot != n-1 || viTriDongRobot != n-1){
                    Map[viTriDongRobot][viTriCotRobot].setBackground(Color.yellow);
                }
             }
         }

//        JOptionPane.showMessageDialog(null, dem);
         //Nếu đi xuống=> dữ nguyên cột tăng dòng
        if(DanhSachNuocDi[dem].getName().equals("xuong")){
            
            Map[viTriDongRobot][viTriCotRobot].setIcon(null);
            viTriDongRobot++;
            CheckWinLose();
             
        }else if(DanhSachNuocDi[dem].getName().equals("phai")){
            Map[viTriDongRobot][viTriCotRobot].setIcon(null);
            viTriCotRobot++;
            CheckWinLose();
        }
        dem++;
        if(dem == soLuongNuocDi || DanhSachNuocDi[dem].getIcon() == null){
            dem = 0;
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnQuaPhai;
    private javax.swing.JButton btnTaoMap;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuongDuoi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblTaomap;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtLevel;
    // End of variables declaration//GEN-END:variables
}
