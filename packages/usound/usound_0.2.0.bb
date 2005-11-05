LICENSE = "GPL"
DESCRIPTION = "The Useful Sound Daemon"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
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
