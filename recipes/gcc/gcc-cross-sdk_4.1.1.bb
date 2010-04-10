PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

DEPENDS += "gmp-native mpfr-native"

SRC_URI[md5sum] = "ad9f97a4d04982ccf4fd67cb464879f3"
SRC_URI[sha256sum] = "985cbb23a486570a8783395a42a8689218f5218a0ccdd6bec590eef341367bb7"
