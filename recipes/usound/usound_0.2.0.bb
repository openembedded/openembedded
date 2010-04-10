LICENSE = "GPL"
DESCRIPTION = "The Useful Sound Daemon"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "pth"

SRC_URI = "http://mattcamp.paunix.org/usound/usound-${PV}.tar.gz"
S = "${WORKDIR}/usound"

do_compile() {
	for dir in lib daemon
	do
		cd ${S}/$dir
		oe_runmake
	done
}

do_stage() {
	oe_libinstall -a -C lib libusound ${STAGING_LIBDIR}
	install -m 0644 lib/usound.h ${STAGING_INCDIR}/
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 daemon/usound ${D}${bindir}
}

SRC_URI[md5sum] = "f863e1c02a8f7b634fd3102274163f8e"
SRC_URI[sha256sum] = "31299e0308d7e1879cba6c54e3c06b1ba8de028d6cf8dc6ff99c0fe9974cefe2"
