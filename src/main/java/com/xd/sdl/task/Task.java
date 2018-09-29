package com.xd.sdl.task;

/**
 * @author duanxiang
 * @since 2018/9/14 22:26
 */
public abstract class Task {

    private Long resourceId;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId){
        this.resourceId = resourceId;
    }


    private Long id;

    private String name;
    /**
     * 0 未开始，1 下载中 2,已完成，3错误
     */
    private int status;
    /**
     * 进度
     */
    private Long percent;
    /**
     * 文件大小
     */
    private int size;

    private String storePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public String toString() {
        return "Task{" +
            "resourceId=" + resourceId +
            ", id=" + id +
            ", name='" + name + '\'' +
            ", status=" + status +
            ", percent=" + percent +
            ", size=" + size +
            ", storePath='" + storePath + '\'' +
            '}';
    }
}
