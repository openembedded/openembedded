PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "a4a3eb15c96030906d8494959eeda23c"
SRC_URI[sha256sum] = "cfc0efbcc6fcde0d416a32dfb246c9df022515a312683fac412578c4fd09a9bc"
