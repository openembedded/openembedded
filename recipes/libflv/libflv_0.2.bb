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

SRC_URI[md5sum] = "5eb6b38393d81f16fb4155fe406e527c"
SRC_URI[sha256sum] = "b53afe2a88fa24bdd53e2a3dd51ab660b89b46b1ba4918735d7331b2e56548d6"
