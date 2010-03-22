require gdb.inc
LICENSE = "GPLv3"

PR = "r1"

DEFAULT_PREFERENCE_avr32 = "99"
SRC_URI_avr32 = " http://avr32linux.org/twiki/pub/Main/GDBPatches/gdb-6.7.1.atmel.1.0.3.tar.bz2"
S_avr32 = "${WORKDIR}/gdb-6.7.1.atmel.1.0.3"
