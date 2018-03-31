public class Main {
    public static void main(String[] args) {
        check1();
        check2();

    }

    private static void check1() {
        StatusTransition.canTransition(Status.処理中, Status.完了);
    }

    private static void check2() {
        try{
            StatusTransition.canTransition(Status.完了, Status.準備中);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
