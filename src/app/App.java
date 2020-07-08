package app;
// package class;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 0;
        
        System.out.print("Nを入力してください：");
        
        Scanner scan = new Scanner(System.in);
        
        try{
            n = Integer.parseInt(scan.nextLine());
            //Nが整数かどうかをチェック
        } catch (NumberFormatException e) {
            System.out.println("整数を入力してください!");
            System.exit(0);
            //Nの入力値が整数でない場合エラーメッセージを表示して終了
        }

        if(1 > n || n > Math.pow(10, 5)*2){
            System.out.println("Nは1以上、100000以下の数値を入力してください");
            System.exit(0);
            //1 ≤ N ≤ 2 × 10^5 かどうかをチェックし、条件に当てはまらなければシステム終了 
        }

        System.out.print("順列をスペースで区切って入力してください：");
        Scanner scanPn = new Scanner(System.in);
        String[] sPn = scanPn.nextLine().split(" ", 0);
        boolean numChk = isNumber(sPn);

        if(!numChk){
            System.out.println("整数を入力してください!");
            System.exit(0);
            //順列Pnが整数かどうかをチェック
        }else if(sPn.length != n){
            System.out.println("Nと同じ数の順列を入力してください!");
            System.exit(0);
            //Nと同じ数の順列が入力されているかチェック
        }
        
        int pn[] = new int[n];
        for(int i = 0; i < n; i++){
            pn[i] = Integer.parseInt(sPn[i]);
        }

        int cnt = 0;
        boolean cntflg = true;        //問題文の条件を満たす整数を数えるためのフラグ
            
        //自分の数値（j）より左にある数値(i)と比較し、自分の方が数値が大きい場合は
        //「任意の整数j(1 ≤ j ≤ i) に対してPi ≤ Pj」の条件に当てはまらない
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(pn[i] > pn[j]){
                    cntflg = false;
                    break;
                }
            }
            if(cntflg) {
                cnt++;
            }
            cntflg = true;  //フラグの初期化
        }
        System.out.println(cnt);
        scan.close();
        scanPn.close();
    }

    public static boolean isNumber(String num[]) {
        //順列Pnとして入力された値が整数かをチェックするメソッド
        try {
            for(String st: num){
                Integer.parseInt(st);
            }
            return true;
            } catch (NumberFormatException e) {
            return false;
        }
    
    }
}