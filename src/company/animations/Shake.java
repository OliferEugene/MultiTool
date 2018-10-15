package company.animations;
/*
Project Task 21 (GUI JavaFx) was created by Eugene Oliferenko 14.10.18
Class Shake was created in 9:37 14.10.18
© 2018 Olifer. All rights reserved. All trademarks are the property of their respective.
*/

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }

    public void playAnim() {
        tt.playFromStart();
    }
}
