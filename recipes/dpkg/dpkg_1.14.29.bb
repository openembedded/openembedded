require dpkg.inc
PR = "r1"
DEPENDS += "zlib bzip2"
#RDEPENDS_${PN} = "${VIRTUAL-RUNTIME_update-alternatives}"
SRC_URI += "file://noman.patch;patch=1"
SRC_URI[src.md5sum] = "4326172a959b5b6484b4bc126e9f628d"
SRC_URI[src.sha256sum] = "ea7ec1c861af43ba534a0d7997774a5f1fd4e25a7eea4ff229c9c7bf89aed633"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-sgml-doc"
