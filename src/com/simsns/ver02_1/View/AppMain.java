package com.simsns.ver02_1.View;

import com.simsns.ver02_1.controller.PostDaoImpl;
import com.simsns.ver02_1.controller.UserDaoImpl;

public class AppMain {

    private final UserView userView = UserView.getInstance();
    private final PostView postView = PostView.getInstance();

    private final PostDaoImpl postDao = PostDaoImpl.getInstance();
    private final UserDaoImpl userDao = UserDaoImpl.getInstance();
    private final Util util = Util.getInstance();


    private AppMain () {}

    public static void main(String[] args) {
        AppMain app = new AppMain();
        boolean run = true;

        System.out.println("********** Simsns **********");

        while (run) {

            if (app.userView.getCurUser() == null) {
                app.userView.signStream();
                continue;
            }

            System.out.println("\n**********************************");

            int menu = app.selectMenu();

            switch (menu) {
                case 0 -> run = false;
                case 1 -> app.postView.read();
                case 2 -> app.postView.createPost();
                case 3 -> app.postView.modifyOrDeletePost();
                case 4 -> app.userView.profileStream();
                default -> System.out.println("\n현재 준비되지 않은 서비스입니다..");
            }
            System.out.println("\n메인메뉴로 돌아갑니다..");
        }
        System.out.println("프로그램이 종료됩니다.. 안녕히 가십쇼!");
    }

    private int selectMenu () {
        int menu = 0;

        System.out.println("\n무엇을 실행할까요?");
        System.out.println("| [0] 종료\t | [1]게시글 목록 \t| [2] 게시글 작성\t \n| [3] 게시글 수정/삭제 | [4] 프로필\t |");

        return util.scan();
    }

}
