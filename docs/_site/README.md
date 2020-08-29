# JavaScript Note

This is a repo recording any important note or thought when learning JavaScript. Most of the note/solution will be based on MOOC course "Code with Mosh" JavaScript Series.

## Prototypes - Note from Code with Mosh

### August 9th, 2020 - Sunday

**project:** transfer all code note for Prototype section

**note:**

- classical inheritance vs prototypical inheritance
  - Object prototype doesn’t have a parent proto
  - prototype is an object, it could save method/property that could be shared in instance
  - when accessing an property or method of an object, it will look up in this object first, if not found, it will look up in its direct parent(prototype), all the way until root object, which is Object prototype.
- property descriptors
- constructor prototype
- don’t modify built-in object
- instance member and prototype member
- iterating instance property and prototype property
- prototype only have access to public member of instance created by constructor, it doesnt have access to constructor's local variable. In other word, because method in prototype is not defined inside a constructor, it does not contain the closure scope as the method defined inside the constructor

**link:** [solution repo](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/prototypes.js)

## Prototypical Inheritance - Note from Code with Mosh

### August 9th, 2020 - Sunday

**project:** transfer all code note for Prototypical Inheritance section

**note:**

- reset constructor

**link:**[solution repo](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/inheritance.js)

## ES6 Class - Note from Code with Mosh

### August 9th, 2020 - Sunday

**project:** transfer all code note for Class section

**note:**

- function hoisting
- [instance method and static method](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/classes.js)
- [private members](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/classes.js):
  - symbol
  - getter and setter
  - weakMap
- [method overriding](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/classes.js): prototypical path to find a method, from child to parent
- [inheritance](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/class/classes.js)
- `this` keyword:
  - `this` keyword - `use strict` mode will be used as default setting in ES6 class
  - in Java class, `this` is used when there is a need to clear ambiguity, such as the instance member's name is the same as the parameter's name passed into the method. if not the case, there is no need to use `this`
  - in JS class, `this` points to current object, we have to use `this` in function to provide running context,see [very useful link](https://www.youtube.com/watch?v=zE9iro4r918)
    - implicit binding
    - explicit binding: bind(),call(),apply()
    - new binding: `new` keyword will implicitly bind function/field to object when creating the instance
    - window
  - there is a clear demo of using class to create instance vs traditional way of creating an instance: [link](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/stopWatch.js)
    - [closure](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures)
    - class is the syntactic sugar over old constructor function
  - getter and setter

## Object - Note from Code with Mosh

### August 9th, 2020 - Sunday

**project:** transfer all code note for Object section

**note:**

- object literal: this can have issue when object have "behavior", function would be duplicated in different object
- [factory function](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/factoryFunction&constructorFunction.js)
- when using constructor function to create an object, `this` will point to an empty object and attach property to it. And we don't need to explicitly return `this` because it will do it automatically
- [constructor property](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/constructorProperty.js): if using object literal, the constructor property will be using Object constructor
- value/primitives types: number,string,boolean,symbol,undefined,null
- reference types: object, function, array
- [adding/removing property](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/add&removeProperties.js): js object can dynamically add/remove properties on the fly
- [enumerate property](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/enumerateProperty.js)
- [function object](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/functionObject.js):
  - function object constructor
  - `func.call()` and `func.apply()` and `func.bind()`
- [private method and property](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/privateMethod&property.js): scope and closure
  - scope is block scope, `let` variable initialize and die in lifecycle of the function
  - [closure](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures): an inner function can access parent variable
- [getter and setter](https://github.com/caffeineGMT/JavaScript_Learning/blob/master/objects/getter&setter.js)
  - [using defineProperty](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty)

## Function - Note from Code with Mosh

### August 8th, 2020 - Saturday

**project:** transfer all code note for Object section

**note:**

- function

## Function - Array.map() and Array.filter()

### August 8th, 2020 - Friday

**project:** understand map and filter func, compare them with Java's similar function

**note:**

- In Java, map function is `function interface`, and filter function is `predicates interface`.
- In Java, the above two interface requires a concrete implementation. In order to use the function, it has to generate from a class which implement the interface. This is called functional interface. Anonymous class and lambda expression are used to quickly provide implementation detail.
- In JS, the above two methods are very similar to Java's concept but the function itself is an object and expect an function object being passed as argument.

**link:**

- [filter](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter)
- [map](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map)

## Function - How to read JavaScript document

### August 8th, 2020 - Saturday

**project:** It is a bit weird to read MDN's JavaScript document. Especially `[,` symbol is very hard to understand

**note:**

- `[,xxx]`is optional argument

**link:** [detailed explaination](http://cassandrawilcox.me/beginners-guide-developer-documentation/)

## Modules - Note from Code with Mosh

### August 7th, 2020 - Thursday

**project:** Question: what is Node.JS?

**note:**

- CommonJS: module.export is an object, we could export the whole class, or attach some object to the export object as properties
- ES6: can use export&export default, when importing, need to use import/import {}
- there is an issue importing the module, that can be fixe in [index.js](https://ui.dev/javascript-modules-iifes-commonjs-esmodules/)

**link:** [solution repo](../module)

## Modules - Node.JS, npm, V8: term kick-off

### August 7th, 2020 - Thursday

**project:** Question: what is Node.JS?

**note:**

- Node.js is a javascript runtime built on JavaScript V8 Engine, written in C++
- JS can only access browser, with NodeJs, it can access local machine and can be used for building utilities, web server, file control, etc
- `npm init` can package the dependencies and create a package.json file for providing dependency info, `npm install` will use this json file to install the required package
- V8 is a high-performance interpreter, help transferring JS code to machine code. It is running in browser but Node.js wraps it and make it run in local machine
- `package-lock.json` is another package version control file, usually we only need to adjust `package.json`

**link:** [youtube](https://www.youtube.com/watch?v=pU9Q6oiQNd0)
