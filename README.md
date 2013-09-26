json-to-csv
===========

A Clojure library that converts JSON input files to CSV output files.


Usage
-----

```bash
git clone https://github.com/olauzon/json-to-csv.git && \
cd json-to-csv && \
mkdir data
```

Given the following input JSON in data/input.json

```json
{"user":{"name":"`=:_uC:LjwIgD0X","password":3869528714570848026},"remote_ip":"192.168.0.1","dt":"Sat Jun 21 06:53:56 EDT 2036"}
{"user":{"name":"gVWg\"BmG|cM;zm\\CBIKLLn.oK:","password":3614901514407423006},"remote_ip":"192.168.1.2","dt":"Sat Jun 14 14:11:34 EDT 1975"}
{"user":{"name":"G\\b=VCrlZCbv2l[L=S\\+O\"#M^EyD]itX|'i","password":5143363558960181380},"remote_ip":"192.168.0.1","dt":"Thu Mar 08 13:17:27 EST 2007"}
{"user":{"name":"?=J)f0l-(\"T:{u@!lQoWaT*Wu[Duo8{EV8n^ZNBfq","password":6267227945623528954},"remote_ip":"192.168.0.1","dt":"Thu Feb 04 22:13:05 EST 1982"}
```

To export `user.password` and `remote_ip` as CSVs to data/output.csv, run

```bash
lein run -m json-to-csv.core data/input.json data/output.csv user.password,remote_ip
```

result

```csv
3869528714570848026,192.168.0.1
3614901514407423006,192.168.1.2
5143363558960181380,192.168.0.1
6267227945623528954,192.168.0.1
```


License
-------

Copyright © 2013 Olivier Lauzon

Distributed under the Eclipse Public License.
