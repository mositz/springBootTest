package org.test.bookpub.akka;

import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by zhangxingxing on 16/10/9.
 */
public class AkkaTest2 extends UntypedActor{

    public static Props createAkkaTest1() {
        return  Props.create(() -> new AkkaTest2());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        getSender().tell(message,getSelf());
    }
}
