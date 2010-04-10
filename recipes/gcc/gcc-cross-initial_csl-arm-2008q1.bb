require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

S = "${WORKDIR}/gcc-4.2"

EXTRA_OECONF += "--disable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap "

SRC_URI[md5sum] = "be1a8a4baeb745af388f4ce09ff7d3e3"
SRC_URI[sha256sum] = "31ca43436520074e90482f54ffe26cc59ea76836add50d8b7d2c1adfefd19845"
