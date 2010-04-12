inherit gpe pkgconfig

DESCRIPTION = "Dictionary access library, used by minipredict."
RRECOMMENDS = "dictionary"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "http://handhelds.org/~paxanima/files/${PN}.tar.gz"

S = "${WORKDIR}/${PN}/"

do_compile() {
	oe_runmake lib
}

FILES_${PN} = "${libdir}/libdictionary.so"
FILES_${PN}-dev = "${libdir}/libdictionary/*.o ${includedir}/libdictionary/*.h"

do_stage() {
	install -d ${STAGING_INCDIR}/libdictionary
	install ${S}/*.h ${STAGING_INCDIR}/libdictionary/
	oe_libinstall -C ${S} libdictionary ${STAGING_LIBDIR}/
}

do_install() {
	install -d ${D}/${libdir}
	install -d ${D}/${libdir}/libdictionary
	install -d ${D}/${includedir}/libdictionary
	install ${S}/libdictionary.so ${D}/${libdir}/
	install ${S}/*.h ${D}/${includedir}/libdictionary/
	install ${S}/*.o ${D}/${libdir}/libdictionary/
}


SRC_URI[md5sum] = "10ee733c70e96e8e9f01d3de2cc0c78c"
SRC_URI[sha256sum] = "46f0a85f340e099e9010c8eb9a28d727830aedb32be48fe0a2f0cd081e0623fd"
