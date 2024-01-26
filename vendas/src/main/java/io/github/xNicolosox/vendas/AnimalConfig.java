package io.github.xNicolosox.vendas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    @Bean(name = "cachorro")
    public Animal cachorro (){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("AU AU AU AU");
            }
        };
    }

    @Bean(name = "gato")
    public Animal gato (){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Miau miau krlh");
            }
        };
    }
}
