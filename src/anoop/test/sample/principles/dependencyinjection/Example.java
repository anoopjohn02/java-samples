package anoop.test.sample.principles.dependencyinjection;

interface Service {
    void write(String message);
}

class ServiceA implements Service {

    @Override
    public void write(String message) {
        System.out.println("Hello " + message);
    }
}

class ClientService {
    private Service service; // dependency inversion (use interface/high level class)

    // inject via the constructor
    public ClientService(Service service) {
        this.service = service;
    }

    // inject via the setter method
    public void setService(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.write("a message");
    }
}

public class Example {
    public static void main(String[] args) {
        Service service = new ServiceA(); //the injector
        ClientService client = new ClientService(service); //inject via the constructor
        client.doSomething();

        client.setService(service); //inject via the setter method
    }
}

