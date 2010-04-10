require libhildon.inc

DEPENDS += "libpng libxt libxi"

SRC_URI = "\
  http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}-1.tar.gz \
  file://libhildon-buildfix.patch;patch=1 \
  "




SRC_URI[md5sum] = "0ac69c278bd9f531a93b3c535f7ff145"
SRC_URI[sha256sum] = "67e74666b49b0d17ff16e209196674dc23faa8c45b4f9b2ad33b94ffb6f3be4c"
