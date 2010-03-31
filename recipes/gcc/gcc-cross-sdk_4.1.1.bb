PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross-sdk.inc

DEPENDS += "gmp-native mpfr-native"
