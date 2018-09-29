package com.xd.sdl.connection;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.connection.http.HttpConnection;
import com.xd.sdl.exception.ConnectExcpetion;
import com.xd.sdl.resource.HttpResource;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/15 20:54
 */
public class ConnectionFactory {

    private  final Map<Long, Connection> connectionCache = new HashMap<>();
    private Configuration configuration;

    public ConnectionFactory(Configuration configuration) {
        this.configuration = configuration;

    }

    public  Connection createConnection(Resource resource) throws ConnectExcpetion {


        if(connectionCache.containsKey(resource.getId())){
            return connectionCache.get(resource.getId());
        }

        Connection conn = null;
        Class<? extends Connection> connClass = configuration.getResourceConnectionMapinng()
            .get(resource.getClass());
        if(Objects.isNull(connClass)){
            throw new ConnectExcpetion("cant't find "+ resource.getClass().getName() +" connection mapping. ");
        }
        try {
             conn = connClass.getDeclaredConstructor(resource.getClass())
                .newInstance(resource);
        } catch (Exception e){
            //....TODO
        }
        connectionCache.put(resource.getId(), conn);

        return conn;
    }


}
