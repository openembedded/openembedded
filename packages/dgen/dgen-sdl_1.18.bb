
SECTION = "x11/games"
DESCRIPTION = "DGen/SDL is a Sega Genesis/Mega-drive emulator."
DEPENDS = "virtual/libsdl"
SRC_URI = "http://pknet.com/~joe/${PN}_${PV}.tar.gz \
	   file://fix-everything.patch;patch=1"

do_compile () {
	oe_runmake dgen 'HOSTCC=${BUILD_CC}' 'TARGET_CC=${CC}' 'TARGET_CXX=${CXX}' 'STAGING_INCDIR=${STAGING_INCDIR}' 'STAGING_LIBDIR=${STAGING_LIBDIR}' 'STAGING_BINDIR=${STAGING_BINDIR}' 'libdir=${libdir}'
}

FILES_${PN} = "${bindir}/dgen ${sysconfdir}/dgenrc"

do_install () {
	install -d ${D}/${bindir}
	install -d ${D}/${sysconfdir}
	install -m 755 -s ${S}/dgen ${D}/${bindir}/
	install -m 644 ${S}/sample.dgenrc.1 ${D}/${sysconfdir}/dgenrc
}
