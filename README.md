![](utm.png "Title")

# TSU Desarrollo de Software Multiplataforma
# Daniel Ivan Escobar Vasquez
# Ruth Martinez Dominguez
# Estructura de Datos - 4F
# 14 de Octubre del 2024

\pagebreak

# Contenido

1. [Practica 5](#practica-5)
1. [Practica 6](#practica-6)
1. [Practica 7](#practica-7)

[Github](https://github.com/MindSetFPS/estructuraDeDatosParcial2)

## Practica 5

Listar  palabras  por  letra  Crea  una  aplicación  para  almacenar  palabras  (solicitadas  al usuario),  la  aplicación  debe  de  separar  las  palabras  y  dividirlas  en  listas  clasificadas  por  la  primera letra  de  la  palabra  es  decir  todas  las  palabras  que  coincidan  en  la  primera  letra.

Creamos una Clase que representa una palabra.

```java
public class Letter {
    public LinkedList<String> wordList  ;   
    public char character;
    public JLabel label;
    
    public Letter(char letter, JLabel label){
        this.wordList = new LinkedList<>();       
        this.character = letter;
        this.label = label;
    }

    public void addWord(String newWorld){
        wordList.add(newWorld);
        String text = character + ": " + "";
        for(String word : wordList){
            text = text + ", " + word;
        }
        label.setText(text);
    }
}

```
El metodo `addWord()` muestra la letra ya la lista de palabras. 

```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {

        String text = textField.getText(); // extract text from input field
        text = text.toLowerCase();
        String[] splitText = text.split("\\s+"); // split words from input field
                                                 
        for (String word : splitText) {
            globalWordList.add(word);
            
            int letterIndex = letters.indexOf(word.charAt(0));

            if (letterIndex != -1) {
                Letter foundLetter = alphabet.get(letterIndex);
                foundLetter.addWord(word);

            } else {
                System.out.println("Character not found in the string.");
            }
        }
        textField.setText("");
    }
```

Se toma el texto, se dividen las palabras y cada una se añade a la respectiva letra.

## Practica 6

Realiza  una aplicación  que  lea  una palabra e  invierta  el orden, por  ejemplo,  si  recibes la palabra UTM el programa debe de invertirla y mostrar MTU.

Cramos una lista enlazada del tipo `Character`.

```java
LinkedList<Character> letters = new LinkedList<>();
```

Aqui tomamos la palabra, creamos una lista enlazada y convierte cada letra en un nodo.
Despues, recorremos la lista de forma invertida, retornando el ultimo elemento. 

```java
String text = word.getText(); // extract text from input field
text = text.toLowerCase();
for (char c : text.toCharArray()) {
    System.out.println(c);
    letters.add(c);
}

String reversedLetters = "";

for (int i = letters.size - 1; i >= 0; i--) {
    System.out.println(i);
    reversedLetters = reversedLetters + letters.get(i);
}
reversedText.setText(reversedLetters);
```

## Practica 7

Un palíndromo  es una palabra, número o frase que se lee igual hacia adelante que hacia atrás, algunos ejemplos de palíndromos son las palabras  “ana”, arenera, arepera, anilina, Malayalam, Oruro, oso, radar, reconocer, rotor, salas, seres, somos, sometemos, entre otras. Realiza un programa que lea una palabra e indique si se trata de un palíndromo o no. 

Creamos una lista enlazada de `Character` como en la practica anterior.
```java
LinkedList<Character> letters = new LinkedList<>();
```

Realizamos los mismos pasos de la practica anterior: almacenar la entrada, cambiar el orden de las letras y remover los espacios. Finalmente, lo comparamos con la original. Si son iguales, significa que estamos ante un palindromo.
```java
if(reversedLetters.equals(text)){
    System.out.println("ES PALINDROMO");
}
reversedText.setText(reversedLetters);
```

## Práctica 8

Práctica  8.  Realiza  una  aplicación  que  mediante  pilas  sume  números  enteros  muy  grandes,  puedes 
leer los números como string, ingresarlos cada uno de ellos a una pila y realizar la suma.

**Estructura del software**

El programa está compuesto por una clase llamada `Practica8` que es la clase principal de la aplicación. Esta clase tiene tres atributos:

*   `firstStack`: Una pila (`Stack`) que almacena el primer número en formato de lista.
*   `secondStack`: Otra pila (`Stack`) que almacena el segundo número en formato de lista.
*   `resultStack`: Una tercera pila (`Stack`) donde se almacenará el resultado de la suma.

La clase también tiene un panel (`JPanel`) llamado `panel` que será utilizado para visualizar los componentes gráficos de la aplicación.

**Método `init()`**

El método `init()` es el constructor de la clase. Se llama automáticamente cuando se crea una instancia de la clase `Practica8`. En este método, se crean los siguientes componentes gráficos:

*   Dos campos de texto (`JTextField`) para introducir los dos números enteros.
*   Un botón (`JButton`) con el texto "sumar" que se utiliza para ejecutar la operación de suma.
*   Un etiqueta (`JLabel`) para mostrar el resultado de la suma.

La pila `firstStack` y la pila `secondStack` se inicializan vacías. El método `init()` también llama al método `sumNumbers()` cuando el botón "sumar" es pulsado.

**Método `sumNumbers(int firstNumber, int secondNumber)`**

Este método es llamado automáticamente cuando el botón "sumar" es pulsado. Recibe como parámetros los dos números enteros introducidos en los campos de texto.

El método `sumNumbers()` intenta sumar los dos números enteros y almacena el resultado en la pila `resultStack`. El método realiza lo siguiente:

1.  **Validación de vacío**: Comprueba si las pilas están vacías. Si es así, se comienza a sumar desde ambos extremos.
2.  **Suma de dígitos**: Intenta sumar los dos números enteros y almacena el resultado en la pila `resultStack`. Si el resultado supera 9, se utiliza el algoritmo de división para dividirlo por 10 y almacenar el resto en la pila.
3.  **Repetición del proceso**: El método se llama recursivamente con los nuevos números enteros resultantes hasta que no haya más dígitos a sumar.

El programa utiliza dos pilas (`Stack`) para almacenar los números enteros introducidos por el usuario. La pila `resultStack` almacena el resultado de la suma. El método `sumNumbers()` utiliza las pilas para realizar la operación de suma.

La implementación de la recursividad en el método `sumNumbers()` permite que el programa maneje sumas de números enteros con múltiples dígitos.

## Práctica 9

La clase `Replacer` tiene dos métodos principales:

1. **Constructor vacío**: El constructor `public void Replacer(){}` no realiza ninguna operación específica, simplemente se declara el tipo de método y el nombre de la clase. No es necesario en este contexto porque la clase no necesita inicializar ningún estado.

2. **Método `replace`**: Su función es reemplazar todos los elementos de una pila (`Stack`) que tengan un valor igual a `oldNumber` con otro valor, especificado por `newNumber`.

### Análisis del Método replace

El método `public void replace( Stack stack, int oldNumber, int newNumber){}` acepta tres parámetros:
- `stack`: La pila en la que se realizarán los reemplazos.
- `oldNumber`: El valor que actualmente contiene un elemento de la pila y que se debe reemplazar.
- `newNumber`: El nuevo valor que reemplazará a `oldNumber` en la pila.

El método implementa una iteración sobre cada nodo (`StackNode`) de la pila. Si el valor del dato (`data`) de un nodo coincide con `oldNumber`, se actualiza ese dato por `newNumber`. La iteración continúa hasta llegar al final de la lista, lo que indica mediante el estado `currentNode.next == null`.

- **Pila (Stack)**: Esta estructura de datos es implementada a través de la clase `Stack` y sus nodos (`StackNode`) representan los elementos en la pila. La pila es una colección que se accede por el final, donde las inserciones y extracciones se realizan de manera LIFO (Last-In-First-Out).

## Práctica 10

Este software parece ser una aplicación de simulación para un sistema de atención al público, similar a un banco o una oficina de correos. La aplicación permite agregar clientes a una cola (cola) y atender a los clientes en orden de llegada.

**Cliente.java**

Este archivo define la clase `Cliente`, que representa a cada cliente en la cola. Cada objeto `Cliente` tiene las siguientes propiedades:

*   `numeroTurno`: un número entero que identifica el turno del cliente.
*   `nombre`: una cadena que representa el nombre del cliente.
*   `tipoMovimiento`: una cadena que indica el tipo de movimiento del cliente (por ejemplo, "Pago de servicio", "Deposito", etc.).
*   `horaLlegada`: un objeto `LocalDateTime` que representa la hora en que llegó el cliente.

La clase `Cliente` tiene un constructor que inicializa los atributos con los valores proporcionados como parámetros. También hay métodos getter y setter para acceder y modificar cada uno de los atributos.

**Practica10.java**

*   **Campos:**
    *   `clientQueue`: una cola de clientes (implementada como una lista enlazada).
    *   `clientTableModel`: un modelo de tabla para mostrar los datos de los clientes.
    *   `turnField` y `clientTextField`: campos de texto para introducir el número de turno del cliente y su nombre, respectivamente.
    *   `movimientosDropwdown`: un desplegable que muestra los tipos de movimiento disponibles.
*   **Métodos:**

    1.  **`customerData()`**: crea la interfaz de usuario para ingresar datos del cliente (número de turno, nombre y tipo de movimiento).
    2.  **`createButtons()`**: crea los botones "Agregar a la cola" y "Atender en ventanilla".
    3.  **`addToQue`**: agrega un nuevo cliente a la cola cuando se hace clic en el botón "Agregar a la cola". Lee los datos del cliente desde los campos de texto y el desplegable, crea un objeto `Cliente` y lo agrega a la cola.
    4.  **`serveWindow()`**: atiende al primer cliente en la cola cuando se hace clic en el botón "Atender en ventanilla". Calcula el tiempo que pasó desde que llegó el cliente hasta que fue atendido, muestra un diálogo de confirmación con este tiempo y retira el cliente de la cola.
    5.  **`createTable()`**: crea una tabla para mostrar los datos de los clientes en la cola.

**Funcionamiento**

1.  Se abre la aplicación y se muestra la interfaz de usuario con campos para introducir datos del cliente, un desplegable con tipos de movimiento y botones "Agregar a la cola" y "Atender en ventanilla".
2.  Cuando se hace clic en el botón "Agregar a la cola", se crea un nuevo cliente con los datos ingresados y se agrega a la cola.
3.  Si hay clientes en la cola, se puede hacer clic en el botón "Atender en ventanilla" para atender al primer cliente en la cola. El tiempo que pasó desde que llegó el cliente hasta que fue atendido se calcula y se muestra en un diálogo de confirmación.
4.  Si no hay clientes en la cola, se puede hacer clic en el botón "Atender en ventanilla" para desactivar la opción.



## Práctica 11

**Clase Car**

La clase `Car` representa a un auto con un color específico. Cada objeto de esta clase tiene las siguientes propiedades:

* `icon`: Un objeto `ImageIcon` que representa la imagen del auto.
* `label`: Un objeto `JLabel` que muestra el texto del color del auto.
* `imagePath`: La ruta de la imagen del auto (no se utiliza en este código).
* `color`: El color del auto, que se genera aleatoriamente al crear un objeto de esta clase.

Los métodos de la clase `Car` son:

* `generateColor()`: Genera un color aleatorio para el auto.
* `Car(JPanel panel)`: Crea un objeto de esta clase con un panel de destino y agrega el objeto a ese panel. Se utiliza para agregar los autos al juego.

**Clase Practica11**

La clase `Practica11` representa la aplicación principal del juego. Esta clase tiene las siguientes propiedades:

* `carsStack`: Una pila (utilizando la clase `Stack`) que contiene objetos `Car`.
* `carPanel`: Un panel de destino para agregar los autos y otros componentes.
* `beginTime`, `finishTime`, `playingTime` y `scorel`: Variables que se utilizan para calcular el tiempo jugado y la puntuación.

Los métodos de la clase `Practica11` son:

* `Practica11(JPanel panel)`: Crea un objeto de esta clase con un panel de destino y configura la aplicación.
* `addCar()`: Agrega autos a la pila en intervalos de tiempo (1000 ms = 1 segundo). Cuando se completa la pila, finaliza el juego y muestra una ventana de resultado.
* `createGrid()`: Crea un grid de botones con colores que corresponden a los autos en la pila. Al seleccionar un par de botones del mismo color, incrementa la puntuación.

**Método addCar**

Se utiliza para agregar autos a la pila en intervalos de tiempo. Cuando se completa la pila (es decir, cuando hay 5 autos), finaliza el juego y muestra una ventana de resultado. El código es lo siguiente:

**Método createGrid**

El método `createGrid()` se utiliza para crear un grid de botones con colores que corresponden a los autos en la pila. Al seleccionar un par de botones del mismo color, incrementa la puntuación. El código es lo siguiente:


## Práctica 12

**Constructores**

* El constructor `public Practica12(JPanel panel, JFrame frame)` recibe dos parámetros: un panel y un marco (JFrame). Este constructor se utiliza para inicializar la aplicación.

**Métodos**

* La variable `Deque<Car> carQue` es una pila de autos, implementada con la clase `LinkedList`. Esta pila se utiliza para almacenar información sobre los autos que se registran en la aplicación.
* El método `public Practica12(JPanel panel, JFrame frame)` es el constructor principal de la clase. En este método:
 + Se crea un menú (`JMenuBar`) y un menú (`JMenu`) con dos opciones: "Entrada de autos" y "Salida de autos".
 + Se configuran los eventos para cada opción del menú.
 + Se agrega el menú al panel principal.

**Método Entrada de autos**

* El método `input.addActionListener(arg0 -> { ... });` es el evento asociado a la opción "Entrada de autos" en el menú. Este método:
 + Crea un diálogo (`JDialog`) para que el usuario ingrese información sobre un auto.
 + Agrega dos campos de texto (`JTextField`) para la placa y el dueño del auto.
 + Agrega un botón (`JButton`) para guardar la información.
 + Al hacer clic en el botón, se crea un objeto `Car` con los datos ingresados por el usuario y se agrega a la pila (`carQue`).
 + Se imprime en la consola el tamaño de la pila.

**Método Salida de autos**

* El método `output.addActionListener(argx -> { ... });` es el evento asociado a la opción "Salida de autos" en el menú. Este método:
 + Crea un diálogo (`JDialog`) para mostrar la información de los autos registrados.
 + Agrega una etiqueta (`JLabel`) para cada auto en la pila, con la información del auto.
 + Se muestra el diálogo con la información de todos los autos.

**Clase Car**

* La clase `Car` representa un auto y tiene los siguientes atributos:
 + `private String licensePlate`: la placa del auto.
 + `public String owner`: el dueño del auto.
 + `private LocalTime arrivalTime = LocalTime.now();`: la hora de llegada del auto (inicializada con la hora actual).
 + `public LocalTime leaveTime`: la hora de salida del auto (no inicializada).
 + `public long totalTime`: el tiempo total que ha estado en parqueo.
* El constructor `Car(String licensePlate, String owner)` se utiliza para crear un objeto `Car` y realiza las siguientes acciones:
 + Inicializa los atributos con los datos ingresados por el usuario.
 + Genera un número aleatorio entre 1 y 1000 y lo usa para calcular la hora de salida del auto (sumando ese número a la hora de llegada).
 + Calcula el tiempo total que ha estado en parqueo, considerando que la hora de salida es mayor que la hora de llegada.
 + Imprime en la consola la hora de llegada y salida, así como el tiempo total.



