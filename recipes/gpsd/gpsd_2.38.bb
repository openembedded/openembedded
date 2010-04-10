require gpsd.inc

PR = "r2"
# make attempts to link gpspacket.so without waiting for all compiler tasks:
PARALLEL_MAKE = ""

SRC_URI[gpsd.md5sum] = "725c320ca6fa35bcdaa1de2d8908f392"
SRC_URI[gpsd.sha256sum] = "ae828da850ac0590fd47768856c4ec29021332204182abe4ad94098d72168474"
