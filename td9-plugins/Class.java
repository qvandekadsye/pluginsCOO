Class<?> c = Class.forName("org.timoleon.Cucurbitace"); // retourne la classe MyClass
// c est dans Class<org.timoleon.Cucurbitace>
Cucurbitace ref = c.newInstance();

// Obtention des constructeurs
Constructor k = c.getConstructor(String.class);
Cucurbitace ref = k.newInstance("abc"); // <=> ref = new Cucurbitace("abc")
Constructor k = c.getConstructor(Integer.TYPE); // correspond au contructeur Cucurbitace(int)

// Invocation d'une méthode
Method<?> m = c.getMethod("f", String.class, Letter.class)
m.invoke(c, "Hello world!", new Letter());

(Cucurbitace.class).isAsignableFrom(Citrouille.class) // indique si on peut écrire Cucurbitace c = new Citrouille(); (ici, non)
