DESCRIPTION="Libflv is able to create FLV streams for use with Flash/SWF movies."
HOMEPAGE="http://klaus.geekserver.net/libflv/"
LICENSE="GPLv2"

DEPENDS="zlib"

SRC_URI="http://klaus.geekserver.net/libflv/libflv.tar.gz"
S = "${WORKDIR}/${PN}/src"

CFLAGS += " -L${STAGING_LIBDIR} "

do_compile() {
        oe_runmake 
}

do_install() {
	install -d ${D}${libdir}
	install libflv.so ${D}${libdir}
}

do_stage() {
	install libflv.h ${STAGING_INCDIR}
}
