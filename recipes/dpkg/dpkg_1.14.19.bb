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

SRC_URI[md5sum] = "dad1a4a08c475b31a6b62e7dc92fe9d2"
SRC_URI[sha256sum] = "5287e943265b9efe5bd59cd1f3145d3fbf9e266df28938ad78e2107fde3c1587"
