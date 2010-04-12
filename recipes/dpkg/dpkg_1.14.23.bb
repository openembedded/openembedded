require dpkg.inc
PR = "r2"
DEPENDS += "zlib bzip2"
#RDEPENDS_${PN} = "${VIRTUAL-RUNTIME_update-alternatives}"
SRC_URI += "file://noman.patch;patch=1"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc"

SRC_URI[md5sum] = "9c1744d32ceed71cbe1db863f64d329d"
SRC_URI[sha256sum] = "7d27f2389e05b8727c6a7126c0b65d67749c170ba143e648912a88f2fe707bca"