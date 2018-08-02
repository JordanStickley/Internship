package com.oreillyauto.projecttemplate.domain;

import java.util.List;
import java.util.Map;

public class LovedTrack {
    private List<Map<String, Object>> track;

    public LovedTrack() {

    }

    public List<Map<String, Object>> getTrack() {
        return track;
    }

    public void setTrack(List<Map<String, Object>> track) {
        this.track = track;
    }
}
