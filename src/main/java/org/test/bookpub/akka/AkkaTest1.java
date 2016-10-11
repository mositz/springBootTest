package org.test.bookpub.akka;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by zhangxingxing on 16/10/9.
 */

public class AkkaTest1 extends UntypedActor {

   public static Props createAkkaTest1() {
      return  Props.create(() -> new AkkaTest1());
   }

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        log.info(message.toString());
        getSender().tell("11",getSelf());
    }
}


