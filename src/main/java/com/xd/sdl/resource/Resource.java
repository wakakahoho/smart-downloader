package com.xd.sdl.resource;

/**
 * @author duanxiang
 * @since 2018/9/14 22:28
 */
public abstract class Resource {

    private Long id;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resource{" +
            "id=" + id +
            ", url='" + url + '\'' +
            '}';
    }
}
