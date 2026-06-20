package numer0n.service.impl;

import numer0n.service.NumeronResult;

public class NumeronResultImpl implements NumeronResult {
    private String answer;

    private String input;

    private boolean isClear;

    private int eat;

    private int bite;

    public String getAnswer() {
        return answer;
    }

    public String getInput() {
        return input;
    }

    public boolean isClear() {
        return isClear;
    }

    public int getEat() {
        return eat;
    }

    public int getBite() {
        return bite;
    }

    public NumeronResultImpl(String answer, String input) {
        this.answer = answer;
        this.input = input;

        this.initialize();

        this.check();
    }

    private void initialize() {
        this.isClear = false;
        this.eat = 0;
        this.bite = 0;
    }

    private void check() {
        if (this.input.matches(this.answer)) {
            // ゲームクリア
            this.isClear = true;
            this.eat = 3;

            return;
        }

        // 1桁目
        if (this.input.matches(this.answer.substring(0, 1) + "[0-9]{2}")) {
            this.eat++;
        } else if (this.input.substring(0, 1).matches("[" + this.answer + "]")) {
            this.bite++;
        }

        // 2桁目
        if (this.input.matches("[0-9]" + this.answer.substring(1, 2) + "[0-9]")) {
            this.eat++;
        } else if (this.input.substring(1, 2).matches("[" + this.answer + "]")) {
            this.bite++;
        }

        // 3桁目
        if (this.input.matches("[0-9]{2}" + this.answer.substring(2, 3))) {
            this.eat++;
        } else if (this.input.substring(2, 3).matches("[" + this.answer + "]")) {
            this.bite++;
        }
    }
}
