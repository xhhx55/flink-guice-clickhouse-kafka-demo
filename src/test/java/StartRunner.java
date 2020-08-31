import com.evente.controller.DemoController;
import com.evente.service.Animal;
import com.evente.service.impl.Bird;
import com.evente.service.impl.Dog;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class StartRunner {

    public static class BindModule implements Module {
        @Override
        public void configure(Binder binder) {
            // 在注入的时候，遇到Service接口类型，全部注入成DefaultService实例
            binder.bind(Animal.class).annotatedWith(Names.named("dogServiceImpl")).to(Dog.class);
            binder.bind(Animal.class).annotatedWith(Names.named("birdServiceImpl")).to(Bird.class);
            binder.bind(DemoController.class).annotatedWith(Names.named("demoController")).to(DemoController.class);
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BindModule());

        Animal bird = injector.getInstance(Bird.class);

        bird.move();


        Animal dog = injector.getInstance(Dog.class);

        dog.move();


        DemoController demoController = injector.getInstance(DemoController.class);

        demoController.test();

    }
}


