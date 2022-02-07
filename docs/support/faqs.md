# FAQS and Common Errors

* [Harvest / Registry Manager](#harvest---registry-manager)
  + [Frequently Asked Questions](#ingest-faqs)
  + [Common Errors](#ingest-errors)
* [Registry / API](#registry---api)
  + [Frequently Asked Questions](#registry-faqs)
  + [Common Errors](#registry-errors)

---

## Harvest / Registry Manager


### Frequently Asked Questions <a name="ingest-faqs"></a>
TBD



### Common Errors <a name="ingest-errors"></a>

---

#### [INFO] Skipping product `/path/to/product`
**Description:** When using the `<bundles>` configuration, Harvest only parses **primary products** (from the collection inventory) and skips products that have already been ingested into the Registry.

**Resolution:** None, as this is expected behavior. If you would like for force Harvest to parse **secondary products** use the `<directories>` configuration. See the [Harvest documentation](https://nasa-pds.github.io/pds-registry-app/operate/harvest.html) for more details.

---

#### Exception in thread "main" java.lang.reflect.InvocationTargetException!
**Descripton:** If you see an Exception like this get thrown and the output looks something like this:

```
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:48)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:87)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:51)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:52)
Caused by: java.lang.NoSuchMethodError: java.lang.String.isBlank()Z
```

**Resolution:** This error means you are running the wrong version of Java. See the [Java Installation](https://nasa-pds.github.io/pds-registry-app/install/java.html) for more details.

---

### Registry / API

### Frequently Asked Questions <a name="registry-faqs"></a>
TBD

### Common Errors <a name="registry-errors"></a>
TBD
