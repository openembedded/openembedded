require gpsd.inc

PR = "r0"
# make attempts to link gpspacket.so without waiting for all compiler tasks:
PARALLEL_MAKE = ""

SRC_URI[gpsd.md5sum] = "3db437196a6840c252fca99b6c19d4d0"
SRC_URI[gpsd.sha256sum] = "ee3b2fb403112c3871e7e4fdb915cdc25b020f3208318ba61e9ac37692832a21"
