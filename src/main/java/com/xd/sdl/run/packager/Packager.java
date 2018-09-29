package com.xd.sdl.run.packager;

import com.xd.sdl.resource.Resource;
import com.xd.sdl.task.Task;

/**
 * @author duanxiang
 * @since 2018/9/15 10:57
 */
public interface Packager {

    /**
     * 将资源进行打包
     * @param resource
     * @return
     */
    void packaging(Resource resource);

}
