DESCRIPTION = "wiimote access library"
LICENSE = "GPLv2"
HOMEPAGE = "http://sourceforge.net/projects/libwiimote/"

PR = "r1"

inherit autotools

DEPENDS = "bluez-libs"

SRC_URI = "${SOURCEFORGE_MIRROR}/libwiimote/libwiimote-${PV}.tgz"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}



SRC_URI[md5sum] = "0d8d61dc989d8ad83e1005a26136d388"
SRC_URI[sha256sum] = "a1e9d45a0d4dd367f1371dd477e30ecaa95e59b9fb8635dc9e7f26e4eb231d90"
