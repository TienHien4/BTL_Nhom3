
package view;

import controller.QuanLyBanHang;
import controller.QuanLyNhanVien;
import controller.QuanLySanPham;
import controller.QuanLyThuChi;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DiaNhac;
import model.DiaPhim;
import model.HoaDon;
import model.NhanVien;
import model.Sach;
import model.ThuChi;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;

/**
 *
 * 
 */
public class FrameQuanLy extends javax.swing.JFrame {

    /**
     * Creates new form FrameQuanLy
     */
    QuanLySanPham qlSanPham;
    QuanLyNhanVien qlNhanVien;
    QuanLyBanHang qlBanHang;
    QuanLyThuChi qlThuChi;
    private ArrayList<Sach> ds_Sach;
    private ArrayList<DiaNhac> ds_DiaNhac;
    private ArrayList<DiaPhim> ds_DiaPhim;
    private ArrayList<NhanVien> ds_NhanVien;
    private ArrayList<HoaDon> ds_HoaDon;
    private ArrayList<ThuChi> ds_ThuChi;

    public FrameQuanLy() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("PHẦN MỀM QUẢN LÝ BÁN HÀNG");
        resetTab1();
        resetTab2();
        lb.setText(showDate(lb));
        qlBanHang = new QuanLyBanHang(tableHoaDon);
        qlBanHang.loadDanhSachHoaDon();
        qlSanPham = new QuanLySanPham(tableSanPham);
        qlSanPham.load_SanPham();
        ds_Sach = qlSanPham.getDS_Sach();
        ds_DiaNhac = qlSanPham.getDS_DiaNhac();
        ds_DiaPhim = qlSanPham.getDS_DiaPhim();
        qlNhanVien = new QuanLyNhanVien(tableNhanVien);
        ds_NhanVien = qlNhanVien.getDS_NhanVien();
        qlNhanVien.load_NhanVien();
        qlThuChi = new QuanLyThuChi(tableThuChi);
        ds_ThuChi = qlThuChi.get_DS_ThuChi();
        qlThuChi.loadThuChi();
        ArrayList ds = qlSanPham.thongKe();
        showThongKeSP(ds);
       
    }

    public static void showThongKeNV(ArrayList ds) {
    }

    public static void showThongKeSP(ArrayList ds) {
    }

    public static void showTongThuChi() {
        long tongThu = 0;
        long tongChi = 0;
        tfChi.setEditable(false);
        tfThu.setEditable(false);
        tfLai.setEditable(false);
        for (int i = 0; i < tableThuChi.getRowCount(); i++) {
            if (tableThuChi.getValueAt(i, 2).toString().equalsIgnoreCase("Chi") || tableThuChi.getValueAt(i, 2).toString().equalsIgnoreCase("Nhập Kho") || tableThuChi.getValueAt(i, 2).toString().equalsIgnoreCase("Trả Lương")) {
                tongChi +=Long.parseLong(tableThuChi.getValueAt(i, 3).toString());
            } else {
                tongThu +=Long.parseLong(tableThuChi.getValueAt(i, 3).toString());
            }
        }
        tfChi.setText(tongChi+"");
        tfThu.setText(tongThu+"");
        if (tongThu < tongChi) {
            tfLai.setText("0");
        } else {
            tfLai.setText((tongThu - tongChi) + "");
        }
    }
   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tabKhachHang = new javax.swing.JTabbedPane();
        pnSanPham = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        lblMaSanPham2 = new javax.swing.JLabel();
        lblNhaCungCap2 = new javax.swing.JLabel();
        lblLoaiSanPham2 = new javax.swing.JLabel();
        lblTenSanPham2 = new javax.swing.JLabel();
        lblGiaMua2 = new javax.swing.JLabel();
        lblGiaBan2 = new javax.swing.JLabel();
        tfTenSanPham = new javax.swing.JTextField();
        tfMaSanPham = new javax.swing.JTextField();
        tfNhaCungCap = new javax.swing.JTextField();
        cbLoaiSanPham = new javax.swing.JComboBox<>();
        btCapNhatSanPham = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        tfGiaMua = new javax.swing.JTextField();
        tfGiaBan = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lbsoluong = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        lbthem1 = new javax.swing.JLabel();
        tfThem1 = new javax.swing.JTextField();
        btThemSanPham = new javax.swing.JButton();
        btXoaSanPham = new javax.swing.JButton();
        lbthem2 = new javax.swing.JLabel();
        tfThem2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        tfTenNhanVien = new javax.swing.JTextField();
        tfMaNhanVien = new javax.swing.JTextField();
        btSuaThongTinNhanVien = new javax.swing.JButton();
        btXoaNhanVien = new javax.swing.JButton();
        lblMaNhanVien = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTenTaiKhoan = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        tfTenDangNhap = new javax.swing.JTextField();
        tfMatKhau = new javax.swing.JTextField();
        btThemNhanVien = new javax.swing.JButton();
        lblEmailNhanVien = new javax.swing.JLabel();
        rbtNam = new javax.swing.JRadioButton();
        rbtNu = new javax.swing.JRadioButton();
        btThoat2 = new javax.swing.JButton();
        tfSoDienThoai = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        pnChiTietBanHang1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableThuChi = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btThemThuChi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        tfChi = new javax.swing.JTextField();
        tfThu = new javax.swing.JTextField();
        tfLai = new javax.swing.JTextField();
        btThoatThuChi = new javax.swing.JButton();
        pnKhachHang = new javax.swing.JPanel();
        pnChiTietBanHang = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        lb = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabKhachHang.setBackground(new java.awt.Color(153, 255, 51));
        tabKhachHang.setFocusable(false);
        tabKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Loại Sản Phẩm", "Giá Mua", "Giá Bán", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableSanPham);
        if (tableSanPham.getColumnModel().getColumnCount() > 0) {
            tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jScrollPane3.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Sản Phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        lblMaSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMaSanPham2.setText("Mã Sản Phẩm:");

        lblNhaCungCap2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhaCungCap2.setText("Nhà Cung Cấp:");

        lblLoaiSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLoaiSanPham2.setText("Loại Sản Phẩm:");

        lblTenSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenSanPham2.setText("Tên Sản Phẩm:");

        lblGiaMua2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGiaMua2.setText("Giá Mua:");

        lblGiaBan2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGiaBan2.setText("Giá Bán:");

        tfTenSanPham.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tfMaSanPham.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tfNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cbLoaiSanPham.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Đĩa Nhạc", "Đĩa Phim" }));

        btCapNhatSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btCapNhatSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update-arrow.png"))); // NOI18N
        btCapNhatSanPham.setText("Cập Nhật");
        btCapNhatSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatSanPhamActionPerformed(evt);
            }
        });

        btThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btThoat.setText(" Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        tfGiaMua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tfGiaBan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 204, 0));
        jLabel46.setText("VND");

        jLabel47.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 204, 0));
        jLabel47.setText("VND");

        lbsoluong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsoluong.setText("Số Lượng");

        tfSoLuong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbthem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbthem1.setText("jLabel34");

        tfThem1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btThemSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addproduct.png"))); // NOI18N
        btThemSanPham.setText("Thêm Mới");
        btThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemSanPhamActionPerformed(evt);
            }
        });

        btXoaSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove-button.png"))); // NOI18N
        btXoaSanPham.setText("Xóa");
        btXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSanPhamActionPerformed(evt);
            }
        });

        lbthem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbthem2.setText("jLabel7");

        tfThem2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNhaCungCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTenSanPham2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMaSanPham2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoaiSanPham2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNhaCungCap)
                            .addComponent(tfTenSanPham)
                            .addComponent(tfMaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cbLoaiSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(lbsoluong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSoLuong))
                    .addComponent(btThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCapNhatSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGiaMua2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(lblGiaBan2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(lbthem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbthem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfGiaMua, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(tfGiaBan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfThem1)
                            .addComponent(tfThem2))
                        .addGap(30, 90, Short.MAX_VALUE))))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMaSanPham2, lblNhaCungCap2, lblTenSanPham2, lbsoluong});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfMaSanPham, tfNhaCungCap, tfSoLuong, tfTenSanPham});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblGiaBan2, lblGiaMua2, lblLoaiSanPham2, lbthem1});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaMua2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoaiSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNhaCungCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbthem2)
                            .addComponent(tfThem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfThem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbthem1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsoluong)
                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCapNhatSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblMaSanPham2, lblNhaCungCap2, lblTenSanPham2, lbsoluong});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbLoaiSanPham, tfMaSanPham, tfNhaCungCap, tfSoLuong, tfTenSanPham});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblGiaBan2, lblGiaMua2, lblLoaiSanPham2, lbthem1});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfGiaBan, tfThem1});

        javax.swing.GroupLayout pnSanPhamLayout = new javax.swing.GroupLayout(pnSanPham);
        pnSanPhamLayout.setHorizontalGroup(
        	pnSanPhamLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pnSanPhamLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(pnSanPhamLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
        				.addComponent(jPanel15, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        pnSanPhamLayout.setVerticalGroup(
        	pnSanPhamLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, pnSanPhamLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(44, Short.MAX_VALUE))
        );
        pnSanPham.setLayout(pnSanPhamLayout);

        tabKhachHang.addTab("Sản Phẩm", new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-cart.png")), pnSanPham); // NOI18N

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 51, 255))); // NOI18N

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenNhanVien.setText("Tên Nhân Viên:");

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSoDienThoai.setText("Số Điện Thoại:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGioiTinh.setText("Giới Tính:");

        btSuaThongTinNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSuaThongTinNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update-arrow.png"))); // NOI18N
        btSuaThongTinNhanVien.setText("Cập Nhật");
        btSuaThongTinNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaThongTinNhanVienActionPerformed(evt);
            }
        });

        btXoaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-1.png"))); // NOI18N
        btXoaNhanVien.setText("Xóa");
        btXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaNhanVienActionPerformed(evt);
            }
        });

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMaNhanVien.setText("Mã Nhân Viên:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài Khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        lblTenTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenTaiKhoan.setText("Tên Tài Khoản:");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMatKhau.setText("Mật Khẩu:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(tfTenDangNhap))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(tfTenDangNhap))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblMatKhau, lblTenTaiKhoan});

        btThemNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adduser.png"))); // NOI18N
        btThemNhanVien.setText("Thêm Mới");
        btThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemNhanVienActionPerformed(evt);
            }
        });

        lblEmailNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmailNhanVien.setText("Email:");

        rbtNam.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbtNam);
        rbtNam.setText("Nam");

        rbtNu.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbtNu);
        rbtNu.setText("Nữ");

        btThoat2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btThoat2.setText(" Thoát");
        btThoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10Layout.setHorizontalGroup(
        	jPanel10Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel10Layout.createSequentialGroup()
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addGap(61)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btThemNhanVien, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel10Layout.createSequentialGroup()
        							.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(tfMaNhanVien, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        								.addComponent(tfTenNhanVien, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblEmailNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(tfSoDienThoai, Alignment.TRAILING)
        						.addComponent(tfEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))))
        			.addPreferredGap(ComponentPlacement.RELATED, 135, GroupLayout.PREFERRED_SIZE)
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(jPanel10Layout.createSequentialGroup()
        						.addGap(2)
        						.addComponent(lblGioiTinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(rbtNam, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        						.addGap(99)
        						.addComponent(rbtNu, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        					.addGroup(jPanel10Layout.createSequentialGroup()
        						.addComponent(btSuaThongTinNhanVien, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btXoaNhanVien, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btThoat2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(38))
        );
        jPanel10Layout.setVerticalGroup(
        	jPanel10Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel10Layout.createSequentialGroup()
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addGap(42)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        						.addComponent(rbtNam)
        						.addComponent(rbtNu))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel10Layout.createSequentialGroup()
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(29)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(21)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(tfSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        					.addGap(14)
        					.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblEmailNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        					.addGap(24)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel10Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel10Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btSuaThongTinNhanVien, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        					.addComponent(btXoaNhanVien, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        					.addComponent(btThemNhanVien, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btThoat2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.linkSize(SwingConstants.VERTICAL, new Component[] {lblTenNhanVien, lblSoDienThoai, lblMaNhanVien, lblEmailNhanVien});
        jPanel10Layout.linkSize(SwingConstants.VERTICAL, new Component[] {btSuaThongTinNhanVien, btXoaNhanVien, btThemNhanVien});
        jPanel10Layout.linkSize(SwingConstants.VERTICAL, new Component[] {tfTenNhanVien, tfMaNhanVien, tfSoDienThoai});
        jPanel10Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblTenNhanVien, lblSoDienThoai, lblMaNhanVien, lblEmailNhanVien});
        jPanel10Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btSuaThongTinNhanVien, btXoaNhanVien, btThemNhanVien});
        jPanel10.setLayout(jPanel10Layout);

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Nhân Viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNhanVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNhanVienMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableNhanVien);
        if (tableNhanVien.getColumnModel().getColumnCount() > 0) {
            tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableNhanVien.getColumnModel().getColumn(2).setPreferredWidth(100);
         
        }

        jScrollPane7.setViewportView(jScrollPane8);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9Layout.setHorizontalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel9Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, 1032, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
        	jPanel9Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel9Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel9.setLayout(jPanel9Layout);

        tabKhachHang.addTab("Nhân Viên", new javax.swing.ImageIcon(getClass().getResource("/icon/user.png")), jPanel9);

        pnChiTietBanHang1.setBackground(new java.awt.Color(204, 255, 204));
        pnChiTietBanHang1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Thu Chi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tableThuChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Thu Chi", "Loại Thu Chi", "Thành Tiền", "Ngày"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThuChi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(tableThuChi);
        if (tableThuChi.getColumnModel().getColumnCount() > 0) {
            tableThuChi.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableThuChi.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pnChiTietBanHang1Layout = new javax.swing.GroupLayout(pnChiTietBanHang1);
        pnChiTietBanHang1Layout.setHorizontalGroup(
        	pnChiTietBanHang1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, pnChiTietBanHang1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        			.addContainerGap())
        );
        pnChiTietBanHang1Layout.setVerticalGroup(
        	pnChiTietBanHang1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, pnChiTietBanHang1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnChiTietBanHang1.setLayout(pnChiTietBanHang1Layout);

        jPanel14.setBackground(new java.awt.Color(204, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết Quả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel29.setText("● Tổng Giá Trị  Chi:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel30.setText("● Tổng Doanh Thu:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel31.setText("● Tổng Lãi Trước Thuế:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 204, 0));
        jLabel32.setText("VND");

        jLabel33.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 204, 0));
        jLabel33.setText("VND");

        jLabel36.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 204, 0));
        jLabel36.setText("VND");

        btThemThuChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThemThuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btThemThuChi.setText("Thêm Thu Chi");
        btThemThuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemThuChiActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton4.setText("Chi Tiết");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove-button.png"))); // NOI18N
        jButton11.setText("Xóa Thu Chi");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        tfChi.setText("jTextField1");

        tfThu.setText("jTextField2");

        tfLai.setText("jTextField3");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14Layout.setHorizontalGroup(
        	jPanel14Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel14Layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(jPanel14Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel14Layout.createSequentialGroup()
        					.addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tfThu, 178, 178, 178))
        				.addGroup(jPanel14Layout.createSequentialGroup()
        					.addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tfLai, 178, 178, 178))
        				.addGroup(jPanel14Layout.createSequentialGroup()
        					.addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tfChi, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel14Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel36, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addGap(52)
        			.addComponent(btThemThuChi)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(17))
        );
        jPanel14Layout.setVerticalGroup(
        	jPanel14Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel14Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel14Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel14Layout.createSequentialGroup()
        					.addGroup(jPanel14Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel32)
        						.addComponent(tfChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel14Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel33)
        						.addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel14Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel36)
        						.addGroup(jPanel14Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        							.addComponent(tfLai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap(46, Short.MAX_VALUE))
        				.addGroup(jPanel14Layout.createSequentialGroup()
        					.addGroup(jPanel14Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btThemThuChi, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        					.addGap(83))))
        );
        jPanel14Layout.linkSize(SwingConstants.VERTICAL, new Component[] {btThemThuChi, jButton11});
        jPanel14Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jLabel32, jLabel33, jLabel36});
        jPanel14Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jLabel29, jLabel30, jLabel31});
        jPanel14Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel32, jLabel33, jLabel36});
        jPanel14Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel29, jLabel30, jLabel31});
        jPanel14Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btThemThuChi, jButton4, jButton11});
        jPanel14.setLayout(jPanel14Layout);

        btThoatThuChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThoatThuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btThoatThuChi.setText(" Thoát");
        btThoatThuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatThuChiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(13)
        					.addComponent(pnChiTietBanHang1, 0, 0, Short.MAX_VALUE))
        				.addComponent(btThoatThuChi, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(pnChiTietBanHang1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(btThoatThuChi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        jPanel2.setLayout(jPanel2Layout);

        tabKhachHang.addTab("Doanh Thu", new javax.swing.ImageIcon(getClass().getResource("/icon/money.png")), jPanel2); // NOI18N

        pnChiTietBanHang.setBackground(new java.awt.Color(204, 204, 255));
        pnChiTietBanHang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Mục Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnXacNhan.setText("Xem Chi Tiết");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove-button.png"))); // NOI18N
        btnHuy.setText("Xóa");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Tổng Tiền", "Ngày"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHoaDon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableHoaDon);
        if (tableHoaDon.getColumnModel().getColumnCount() > 0) {
            tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pnChiTietBanHangLayout = new javax.swing.GroupLayout(pnChiTietBanHang);
        pnChiTietBanHang.setLayout(pnChiTietBanHangLayout);
        pnChiTietBanHangLayout.setHorizontalGroup(
            pnChiTietBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChiTietBanHangLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnChiTietBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnChiTietBanHangLayout.createSequentialGroup()
                        .addComponent(btnXacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        pnChiTietBanHangLayout.setVerticalGroup(
            pnChiTietBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietBanHangLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnChiTietBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnChiTietBanHangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnXacNhan});

        lb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Thứ ..... Ngày ..... Tháng ..... Năm .....");

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnChiTietBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnChiTietBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

       
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PHẦN MỀM QUẢN LÝ BÁN HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
            //qlBanHang.writeHoaDonToFile();
            System.exit(0);
        } else {
        }
    }

    private void btThoatThuChiActionPerformed(java.awt.event.ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
            //qlBanHang.writeHoaDonToFile();
            System.exit(0);
        }
    }

    private void btThoat2ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Thông Báo", "Bạn Có Muốn Thoát", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
//            qlBanHang.writeHoaDonToFile();
            System.exit(0);
        }
    }

    private void btThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        qlSanPham.themSanPham();
        resetTab1();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
            //qlBanHang.writeHoaDonToFile();
            System.exit(0);
        }
    }

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tableSanPham.getSelectedRow();
        int sizeSach = ds_Sach.size();
        int sizeDiaNhac = ds_DiaNhac.size();
        int sizeDiaPhim = ds_DiaPhim.size();
        if (i < sizeSach && i != -1) {
            
            cbLoaiSanPham.setSelectedIndex(0);
            lbthem1.setText("Tác Giả");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Nhà Xuất Bản");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_Sach.get(i).getMaSanPham());
            tfTenSanPham.setText(ds_Sach.get(i).getTenSanPham());
            tfNhaCungCap.setText(ds_Sach.get(i).getNhaCungCap());
            tfSoLuong.setText(ds_Sach.get(i).getSoLuong() + "");
            tfGiaMua.setText(ds_Sach.get(i).getGiaMua() + "");
            tfGiaBan.setText(ds_Sach.get(i).getGiaBan() + "");
            tfThem1.setText(ds_Sach.get(i).getTacGia());
            tfThem2.setText(ds_Sach.get(i).getNhaXuatBan());
        } else if ((i < sizeSach + sizeDiaNhac) && i != -1) {
            
            cbLoaiSanPham.setSelectedIndex(1);
            lbthem1.setText("Tên Ca Sỹ");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Thể Loại");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_DiaNhac.get(i - sizeSach).getMaSanPham());
            tfTenSanPham.setText(ds_DiaNhac.get(i - sizeSach).getTenSanPham());
            tfNhaCungCap.setText(ds_DiaNhac.get(i - sizeSach).getNhaCungCap());
            tfSoLuong.setText(ds_DiaNhac.get(i - sizeSach).getSoLuong() + "");
            tfGiaMua.setText(ds_DiaNhac.get(i - sizeSach).getGiaMua() + "");
            tfGiaBan.setText(ds_DiaNhac.get(i - sizeSach).getGiaBan() + "");
            tfThem1.setText(ds_DiaNhac.get(i - sizeSach).getTenCaSy());
            tfThem2.setText(ds_DiaNhac.get(i - sizeSach).getTheLoai());
        } else if ((i < sizeSach + sizeDiaNhac + sizeDiaPhim) && i != -1) {
            
            cbLoaiSanPham.setSelectedIndex(2);
            lbthem1.setText("Tên Đạo Diễn");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Tên Diễn Viên");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getMaSanPham());
            tfTenSanPham.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenSanPham());
            tfNhaCungCap.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getNhaCungCap());
            tfSoLuong.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getSoLuong() + "");
            tfGiaMua.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getGiaMua() + "");
            tfGiaBan.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getGiaBan() + "");
            tfThem1.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenDaoDien());
            tfThem2.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenDienVien());
        }
    }

    private void btCapNhatSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        resetTab1();
        int i = tableSanPham.getSelectedRow();
        if (i != -1) {
            qlSanPham.suaThongTin(i);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy Chọn Một Sản Phẩm", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        int i = tableSanPham.getSelectedRow();
        if (i != -1) {
            int j = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Loại bỏ sản phẩm này", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) {
                qlSanPham.xoaSanPham(i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy Chọn Một Sản Phẩm", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
        resetTab1();
    }

    private void btThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
        qlNhanVien.themNhanVien();
        resetTab2();
    }

    private void btSuaThongTinNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tableNhanVien.getSelectedRow();
        if (index != -1) {
            qlNhanVien.suaThongTinNhanVien(index);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy Chọn Một Nhân Viên", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
        resetTab2();
    }

    private void tableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {
        int index = tableNhanVien.getSelectedRow();
        if (index != -1) {
            NhanVien nv = qlNhanVien.getDS_NhanVien().get(index);
            tfTenNhanVien.setText(nv.getTenNhanVien());
            tfMaNhanVien.setText(nv.getMaNhanVien());
            tfMaNhanVien.setEditable(false);
            if (nv.getGioiTinh().equalsIgnoreCase("Nam")) {
                buttonGroup1.setSelected(rbtNam.getModel(), true);
                rbtNu.setVisible(false);
            } else {
                buttonGroup1.setSelected(rbtNu.getModel(), true);
                rbtNam.setVisible(false);
            }
            tfSoDienThoai.setText(nv.getSoDienThoai());
            tfEmail.setText(nv.getEmail());
         
            
      
            tfTenDangNhap.setText(nv.getTenDangNhap());
            tfMatKhau.setText(nv.getMatKhau());
        }
    }

    private void btXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tableNhanVien.getSelectedRow();
        if (index != -1) {
            int i = JOptionPane.showConfirmDialog(null, "Bạn Có Chăc Chắn Muốn Xóa", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                qlNhanVien.xoaNhanVien(index);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Hãy Chọn Một Nhân Viên", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
        resetTab2();
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int index = tableHoaDon.getSelectedRow();
        int n = 1;
        if (index != -1) {
            try {
                qlBanHang.xoaHoaDon(index);
                JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(FrameQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {
        int i = tableHoaDon.getSelectedRow();
        if (i != -1) {
            qlBanHang.xemChiTiet(i);
        }
    }

    private void btThemThuChiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        qlThuChi.themThuChi();
    }


    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int i = tableThuChi.getSelectedRow();
        if (i != -1) {
            int j = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Xóa", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) {
                if (qlThuChi.xoaThuChi(i)) {
                    JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    qlThuChi.loadThuChi();
                    //howTongThuChi();
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể xóa loại thu chi này", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = tableThuChi.getSelectedRow();
        if (i != -1) {
            qlThuChi.xemChiTiet(tableThuChi.getValueAt(i, 1).toString());
        }
    }

   

    private void resetTab1() {
        lbthem1.setVisible(false);
        lbthem2.setVisible(false);
        tfThem1.setVisible(false);
        tfThem2.setVisible(false);
        tfMaSanPham.setEditable(false);
        tfMaSanPham.setText("");
        tfTenSanPham.setEditable(false);
        tfTenSanPham.setText("");
        tfNhaCungCap.setEditable(false);
        tfNhaCungCap.setText("");
        tfGiaBan.setEditable(false);
        tfGiaBan.setText("");
        tfGiaMua.setEditable(false);
        tfGiaMua.setText("");
        tfSoLuong.setEditable(false);
        tfSoLuong.setText("");
        cbLoaiSanPham.setEnabled(false);
        tfThem1.setEditable(false);
        tfThem2.setEditable(false);
    }

    private void resetTab2() {
        tfMaNhanVien.setEditable(false);
        tfMaNhanVien.setText("");
        tfTenNhanVien.setEditable(false);
        tfTenNhanVien.setText("");
        tfSoDienThoai.setEditable(false);
        tfSoDienThoai.setText("");
        tfEmail.setEditable(false);
        tfEmail.setText("");
        tfTenDangNhap.setEditable(false);
        tfTenDangNhap.setText("");
        tfMatKhau.setEditable(false);
        tfMatKhau.setText("");
    }

    public String showDate(JLabel label) {
        Calendar date = new GregorianCalendar();
        String dateShow = String.valueOf(date.get(Calendar.DATE)) + " Tháng " + String.valueOf(date.get(Calendar.MONTH) + 1) + " Năm " + String.valueOf(date.get(Calendar.YEAR));
        switch (date.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                dateShow = "Chủ Nhật Ngày " + dateShow;
                break;
            case 2:
                dateShow = "Thứ Hai Ngày " + dateShow;
                break;
            case 3:
                dateShow = "Thứ Ba Ngày " + dateShow;
                break;
            case 4:
                dateShow = "Thứ Tư Ngày " + dateShow;
                break;
            case 5:
                dateShow = "Thứ Năm Ngày " + dateShow;
                break;
            case 6:
                dateShow = "Thứ Sáu Ngày " + dateShow;
                break;
            case 7:
                dateShow = "Thứ Bảy Ngày " + dateShow;
                break;
            default:
                break;
        }
        return dateShow;
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dates = new Date();
        return dateFormat.format(dates);
    }

    private Date stringToDaTe(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        date = formatter.parse(s);
        return date;
    }

    
    /**
     * @param args the command line arguments
     */


 
    private javax.swing.JButton btCapNhatSanPham;
    private javax.swing.JButton btSuaThongTinNhanVien;
    private javax.swing.JButton btThemNhanVien;
    private javax.swing.JButton btThemSanPham;
    private javax.swing.JButton btThemThuChi;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btThoat2;
    private javax.swing.JButton btThoatThuChi;
    private javax.swing.JButton btXoaNhanVien;
    private javax.swing.JButton btXoaSanPham;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbLoaiSanPham;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblEmailNhanVien;
    private javax.swing.JLabel lblGiaBan2;
    private javax.swing.JLabel lblGiaMua2;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblLoaiSanPham2;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaSanPham2;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNhaCungCap2;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenSanPham2;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JLabel lbsoluong;
    private javax.swing.JLabel lbthem1;
    private javax.swing.JLabel lbthem2;
    private javax.swing.JPanel pnChiTietBanHang;
    private javax.swing.JPanel pnChiTietBanHang1;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnSanPham;
    private javax.swing.JRadioButton rbtNam;
    private javax.swing.JRadioButton rbtNu;
    private javax.swing.JTabbedPane tabKhachHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTable tableSanPham;
    private static javax.swing.JTable tableThuChi;
    private static javax.swing.JTextField tfChi;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfGiaBan;
    private javax.swing.JTextField tfGiaMua;
    private static javax.swing.JTextField tfLai;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfMaSanPham;
    private javax.swing.JTextField tfMatKhau;
    private javax.swing.JTextField tfNhaCungCap;
    private javax.swing.JTextField tfSoDienThoai;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenDangNhap;
    private javax.swing.JTextField tfTenNhanVien;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfThem1;
    private javax.swing.JTextField tfThem2;
    private static javax.swing.JTextField tfThu;
  

}
