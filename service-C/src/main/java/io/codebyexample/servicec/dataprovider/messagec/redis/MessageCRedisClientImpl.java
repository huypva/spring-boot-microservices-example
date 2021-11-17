package io.codebyexample.servicec.dataprovider.messagec.redis;

import io.codebyexample.servicec.core.entity.MessageC;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class MessageCRedisClientImpl implements MessageCRedisClient {

  @Autowired
  RedissonClient redissonClient;

  @Override
  public void setMessageC(MessageC messageC) {
    RBucket<MessageC> bucket = redissonClient.getBucket(messageC.getId() + "");
    bucket.set(messageC);
  }

  @Override
  public MessageC getMessageC(int id) {
    RBucket<MessageC> bucket = redissonClient.getBucket(id + "");
    return bucket.get();
  }
}
