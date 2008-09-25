require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

S = "${WORKDIR}/gcc-4.2"

EXTRA_OECONF += "--disable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap "
