DESCRIPTION = "wiimote access library"
LICENSE = "GPLv2"

PR = "r0"

inherit autotools

DEPENDS = "bluez-libs"

SRC_URI = "${SOURCEFORGE_MIRROR}/libwiimote/libwiimote-${PV}.tgz"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}


