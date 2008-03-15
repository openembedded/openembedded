PR = "r4"

require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc

DEPENDS += "gmp-native mpfr-native"

require gcc3-build-cross.inc
require gcc-package-cross.inc
