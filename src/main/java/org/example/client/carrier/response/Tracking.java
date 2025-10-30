package org.example.client.carrier.response;

import lombok.Data;

import java.util.List;

@Data
public class Tracking {
    private List<String> trackingCode;

    public List<String> getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(List<String> trackingCode) {
        this.trackingCode = trackingCode;
    }
}
