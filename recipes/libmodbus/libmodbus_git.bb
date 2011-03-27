require libmodbus.inc

SRCREV = "6254ede9156095ee0300"

PV = "2.9.3+gitr${SRCPV}"

PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/stephane/libmodbus;branch=master;protocol=git"
S = "${WORKDIR}/git"

