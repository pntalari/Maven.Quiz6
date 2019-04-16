package rocks.zipcode.io.objectorientation;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Television {
    Boolean onTv;
  //  Television television;
    TVChannel channel;

    public Television() {
        this.onTv = false;
        this.channel = null;
    }

    public void turnOn() {
        this.onTv = true;
    }

    public void setChannel(Integer channel) {
        if (this.onTv) {
            this.channel = TVChannel.getByOrdinal(channel);
        }
        else throw new IllegalStateException();
    }

    public TVChannel getChannel() {
        return this.channel;
    }
}
