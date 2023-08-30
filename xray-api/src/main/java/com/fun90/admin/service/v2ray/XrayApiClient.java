package com.fun90.admin.service.v2ray;

import com.xray.app.log.command.LoggerServiceGrpc;
import com.xray.app.proxyman.command.HandlerServiceGrpc;
import com.xray.app.stats.command.StatsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
@AllArgsConstructor
public class XrayApiClient {

	private static final ConcurrentHashMap<String, XrayApiClient> concurrentHashMap = new ConcurrentHashMap();
	private HandlerServiceGrpc.HandlerServiceBlockingStub handlerServiceBlockingStub;
	private LoggerServiceGrpc.LoggerServiceBlockingStub loggerServiceBlockingStub;
	private StatsServiceGrpc.StatsServiceBlockingStub statsServiceBlockingStub;

	public static XrayApiClient getInstance(String host, int port) {
		String key = host + port;
		if (concurrentHashMap.containsKey(key)) return concurrentHashMap.get(key);
		synchronized (key.intern()) {
			if (!concurrentHashMap.containsKey(key)) {
				ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
						// Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
						// needing certificates.
						.usePlaintext()
						.build();
				XrayApiClient v2RayApiClient1 = new XrayApiClient(HandlerServiceGrpc.newBlockingStub(channel),
						LoggerServiceGrpc.newBlockingStub(channel),
						StatsServiceGrpc.newBlockingStub(channel));

				concurrentHashMap.put(key, v2RayApiClient1);
			}
			return concurrentHashMap.get(key);
		}
	}


	public void shutdown() throws InterruptedException {
		// concurrentHashMap.forEachValue();
		//channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


}
