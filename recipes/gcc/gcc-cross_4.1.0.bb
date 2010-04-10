PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-cross4.inc
require gcc-configure-cross.inc
require gcc-package-cross.inc

EXTRA_OECONF += "--disable-libunwind-exceptions --with-mpfr=${STAGING_DIR_NATIVE}${prefix_native}"

SRC_URI[md5sum] = "88785071f29ed0e0b6b61057a1079442"
SRC_URI[sha256sum] = "1159457a0e4c054b709547ae21ff624aebab2033e0d9e5bf46c9cf88b1970606"
