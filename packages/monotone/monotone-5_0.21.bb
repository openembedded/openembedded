include monotone.inc

PR = "r0"

SRC_URI = "http://venge.net/monotone/downloads/monotone-${PV}.tar.gz \
           file://txt2c-cross.patch;patch=1 \
           file://cryptopp-endianness.patch;patch=1 \
	   file://configure.ac.patch;patch=1 \
	   file://uclibc.database.hh.stdarg.patch;patch=1 \
	   "

ALTERNATIVE_PRIORITY = "50"
