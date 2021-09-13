package programmers;

import java.util.Arrays;

public class KakaoKeyPad {
    public static void main(String[] args) {
        KakaoKeyPad kakaoKeyPad = new KakaoKeyPad();

        int[][] inputs = {
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };
        String[] hands = {"right", "left", "right"};
        String[] answer = {
                "LRLLLRLLRRL",
                "LRLLRRLLLRR",
                "LLRLLRLLRL"
        };

        for (int i = 0; i < inputs.length; i++) {
            String guess = kakaoKeyPad.solution(inputs[i], hands[i]);
            System.out.printf("input: [%s] , Guess: [%s] , answer: [%s] , result: %s%n",
                    Arrays.toString(inputs[i]), guess, answer[i], answer[i].equals(guess)
            );
        }
    }


    public String solution(int[] numbers, String hand) {
        int currentLeftThumb = 10;
        int currentRightThumb = 12;
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                currentLeftThumb = number;
            } else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                currentRightThumb = number;
            }else {
                // get target distance
                int leftDistance = getDistance(currentLeftThumb, number);
                int rightDistance = getDistance(currentRightThumb, number);

                if(leftDistance < rightDistance){
                    sb.append("L");
                    currentLeftThumb = number;
                } else if(leftDistance > rightDistance){
                    sb.append("R");
                    currentRightThumb = number;
                } else if(hand.equals("left")){
                    sb.append("L");
                    currentLeftThumb = number;
                } else {
                    sb.append("R");
                    currentRightThumb = number;
                }
            }
        }

        return sb.toString();
    }

    private int getDistance(int currentFinger, int target){
        if(currentFinger == 0){
            currentFinger = 11;
        }

        if(target == 0){
            target = 11;
        }

        int fingerX = (currentFinger - 1) / 3;
        int fingerY = (currentFinger - 1) % 3;
//        System.out.println("fingerX = " + fingerX + " , fingerY = " + fingerY);
        int targetX = (target - 1) / 3;
        int targetY = (target - 1) % 3;
//        System.out.println("targetX = " + targetX + " , targetY = " + targetY);

        return Math.abs(targetX - fingerX) + Math.abs(targetY - fingerY);
    }
}
