package hello.serveltt.web.frontcontroller.v3;

import hello.serveltt.web.frontcontroller.ModelView;

import java.util.Map;
import java.util.Objects;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
