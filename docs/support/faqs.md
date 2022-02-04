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

#### [INFO] Skipping product `/path/to/product`
**Description:** When using the `<bundles>` configuration, Harvest only parses **primary products** (from the collection inventory) and skips products that have already been ingested into the Registry.

**Resolution:** None, as this is expected behavior. If you would like for force Harvest to parse **secondary products** use the `<directories>` configuration. See the [Harvest documentation](https://nasa-pds.github.io/pds-registry-app/operate/harvest.html) for more details.

#### [WARN] Could not find prefix for URI `http://path/to/PDS4_SCHEMA.xsd`
**Descripton:** TBD
**Resolution:** TBD

---

### Registry / API

### Frequently Asked Questions <a name="registry-faqs"></a>
TBD

### Common Errors <a name="registry-errors"></a>
TBD
