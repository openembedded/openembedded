require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

S = "${WORKDIR}/gcc-4.2"

EXTRA_OECONF += "--disable-libmudflap \
		--disable-libssp"
