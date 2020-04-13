package com.wandou.mq.rocket;

import com.alibaba.fastjson.JSON;
import com.wandou.constant.RocketMQConstant;
import com.wandou.model.dto.MatterLogDTO;
import com.wandou.service.MatterLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liming
 * @date 2020-03-29
 */

@Service
@Slf4j
@RocketMQMessageListener(topic = RocketMQConstant.DEMO0819_TOPIC, consumerGroup = RocketMQConstant.MOUSE_CONSUMER_GROUP)
public class Demo0819MQListener implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {
    @Autowired
    private MatterLogService matterLogService;


    @Override
    public void onMessage(MessageExt message) {
        log.info("======================= Demo0819MQListener收到mq消息,msg={}", message);
        String msgId = message.getMsgId();
        String tags = message.getTags();
        log.info("msgId: {}, msgKey: {}, tags: {}", msgId, message.getKeys(), tags);
        log.info("msgBody: {}", message.getBody());
        String msgBodyStr = new String(message.getBody());
        log.info("msgBodyStr: {}", msgBodyStr);
        MatterLogDTO matterLogDTO = JSON.parseObject(msgBodyStr, MatterLogDTO.class);
        Long userId = 23L;
        if (matterLogDTO != null && matterLogDTO.getUserId() != null) {
            userId = matterLogDTO.getUserId();
        }
        matterLogService.addMatterLogByMqDemo(userId, matterLogDTO.getMType(), msgBodyStr);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setInstanceName(RocketMQConstant.MOUSE_CONSUMER_GROUP + "-InstanceName");
    }


}
