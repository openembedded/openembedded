include monotone.inc

SUBV = "1"
PR = "r0"

SRC_URI = "http://www.venge.net/monotone/downloads/monotone_${PV}-${SUBV}.tar.gz \
           file://txt2c-cross.patch;patch=1 \
           file://cryptopp-endianness.patch;patch=1"
