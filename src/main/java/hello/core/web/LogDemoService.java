package hello.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLoggerProvider;

    public void logic(String id){
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLoggerProvider.log("service id = " + id);
    }
}
