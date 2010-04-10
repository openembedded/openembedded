require gdbserver.inc

LICENSE = "GPLv3"

PR = "${INC_PR}.1"

DEFAULT_PREFERENCE_avr32 = "99"
SRC_URI_avr32 = " http://avr32linux.org/twiki/pub/Main/GDBPatches/gdb-6.7.1.atmel.1.0.3.tar.bz2"
S_avr32 = "${WORKDIR}/gdb-6.7.1.atmel.1.0.3"


SRC_URI[md5sum] = "7a74dcafdd39d18678e5b5cc2c50bb0c"
SRC_URI[sha256sum] = "66e6ff871a7ed71ea433b8341ffebbe48590119e43a42953d392f5ce517c95e4"
