 package com.oreillyauto.projecttemplate.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private LovedTrack lovedtracks;

    public Response() {

    }

    public LovedTrack getLovedtracks() {
        return lovedtracks;
    }

    public void setLovedtracks(LovedTrack lovedtracks) {
        this.lovedtracks = lovedtracks;
    }
}


