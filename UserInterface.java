import java.util.Scanner;

public class UserInterface {


        public static void TampilkanMenu(){
            System.out.println();
            System.out.println("+================+");
            System.out.println("|  Pilih Menu:   |");
            System.out.println("==================");
            System.out.println("  [C] : CREATE   |");
            System.out.println("  [R] : READ     |");
            System.out.println("  [U] : UPDATE   |");
            System.out.println("  [D] : DELETE   |");
            System.out.println("  [X] : EXIT     |");
            System.out.println("+================+");


    }
    public static void main(String[] args) {
        Database db = new Database();
        System.out.println("WELCOME APLIKASI SIMPLE CRUD TEXT DATABASE");
        while (true){
        TampilkanMenu();
            Scanner sc = new Scanner(System.in);
            System.out.println("Pilih : ");
            String pilihan = sc.next();
            pilihan = pilihan.toUpperCase();

            switch (pilihan){
                case "C":
                    System.out.println("ANDA MEMILIH MENU CREATE");
                    System.out.println("--------------------------------------");
                    System.out.println("INPUT DATA BARU ");
                    System.out.print("NIM            :");
                    String nim = sc.next();
                    System.out.print("NAMA MAHASISWA :");
                    String nama = sc.next();
                    System.out.print("ALAMAT         :");
                    String alamat = sc.next();
                    System.out.print("SEMESTER       :");
                    int semester = sc.nextInt();
                    System.out.print("SKS            :");
                    int sks = sc.nextInt();
                    System.out.print("IPK            :");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("-----------------------------------");
                    boolean status = db.insert(nim,nama,alamat,semester,sks,ipk);

                    if(status==true){
                        System.out.println("DATA BARU BERHASIL DITAMBAHKAN");
                    }else {
                        System.out.println("NIM "+nim+" Sudah ada di DataBase");
                        System.out.println("GAGAL MENAMBAHKAN DATA BARU");
                    }
                    System.out.println("-----------------------------------");
                    break;

                case "R":
                    System.out.println("ANDA MEMILIH MENU READ ");
                    db.view();
                    break;

                case "U":
                    System.out.println("INFO : ANDA MEMILIH MENU UPDATE ");
                    db.view();
                    System.out.println("Input key(NIM Mahasiswa yang akan diUpdate): ");
                    String key = sc.next();
                    int index =db.search(key);
                    if (index >= 0){
                        System.out.println("Anda akan meng-Update data "+db.getData().get(index));
                        System.out.println("--------------------------------------");
                        System.out.println("INPUT DATA BARU ");
                        System.out.print("NIM            :");
                        nim = sc.next();
                        System.out.print("NAMA MAHASISWA :");
                        nama = sc.next();
                        System.out.print("ALAMAT         :");
                        alamat = sc.next();
                        System.out.print("SEMESTER       :");
                        semester = sc.nextInt();
                        System.out.print("SKS            :");
                        sks = sc.nextInt();
                        System.out.print("IPK            :");
                        ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("-----------------------------------");
                        status = db.update(index,nim,nama,alamat,semester,sks,ipk);

                        if (status == true){
                            System.out.println("DATA BERHASIL DIPERBAHARUI");
                        }else{
                            System.err.println("GAGAL MEMPERBHARUI DATA");
                        }
                        System.out.println("-----------------------------------");
                    }else{
                        System.err.println("Mahasiswa dengan Nim : "+key+" tidak ada di DataBase");
                    }
                    break;

                case "D":
                    System.out.println("INFO : ANDA MEMILIH MENU DELETE");
                    db.view();
                    System.out.println("Input key (Nim Mahasiswa yang akan dihapus : ");
                    key = sc.next();
                    index = db.search(key);
                        if (index >= 0){
                            System.out.println("APAKAH ANDA YAKIN ANDA AKAN MENGHAPUS DATA "+db.getData().get(index)+"? Y/N");
                            System.out.print("Pilih : ");
                            pilihan = sc.next();
                            if(pilihan.equalsIgnoreCase("Y")){
                                status = db.delete(index);
                                if(status==true){
                                    System.out.println("DATA BERHASIL DIHAPUS");

                                }else {
                                    System.err.println("GAGAL MENGHAPUS DATA");
                                }
                            }

                        }else {
                            System.err.println("Mahasiswa dengan NIM: "+key+" tidak ada di DataBase");
                        }
                    break;

                case "X":
                    System.out.println("INFO : Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA INGIN KELUAR DARI APLIKASI? Y/N");
                    System.out.print("Pilih : ");
                    pilihan = sc.next();
                    if (pilihan.equalsIgnoreCase("Y")){
                        System.exit(0);
                    }
                    break;
            }
            }
        }
    }

