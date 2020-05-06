package br.com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) {
        System.out.println("Hello! World!!");

        String bootstrapServers = "127.0.0.1:9092";

        
        //Três passos para criar produtores

        //Criar as propriedades do produtor
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Criar o produtor
        KafkaProducer <String, String> producer = new KafkaProducer<String, String>(properties);

        //criar gravação
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("fist_topic", "Hello World!");

        //enviar dados
        producer.send(record);

        producer.flush();
        producer.close();
        
    }
}
