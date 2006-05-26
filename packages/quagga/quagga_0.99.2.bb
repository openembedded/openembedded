QUAGGASUBDIR = "/attic"
include quagga.inc
PR = "r1"
SRC_URI += "file://ospfd-no-opaque-lsa-fix.patch;patch=1"
