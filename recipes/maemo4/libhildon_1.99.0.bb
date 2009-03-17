require libhildon.inc

DEPENDS += "libpng libxt libxi"

SRC_URI = "\
  http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}-1.tar.gz \
  file://libhildon-buildfix.patch;patch=1 \
  "



