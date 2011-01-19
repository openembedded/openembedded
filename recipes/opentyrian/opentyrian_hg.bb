DESCRIPTION = "OpenTyrian is a port of the DOS shoot-em-up Tyrian."
HOMEPAGE = "https://code.google.com/p/opentyrian/"
SECTION = "games"
LICENSE = "GPLv2"

DEPENDS = "virtual/libsdl libsdl-net"

REV = "3f3819c0b2"
PV = "2.1+hg${REV}"
PR = "r0"

SRC_URI = "hg://opentyrian.googlecode.com/hg;module=opentyrian;rev=${REV} \
	   http://camanis.net/tyrian/tyrian21.zip;name=data"

S = "${WORKDIR}/opentyrian"

FILES_${PN} += " ${datadir}/applications ${datadir}/pixmaps ${datadir}/opentyrian"
FILES_${PN}-doc = "${mandir}/man6"

do_compile() {
	oe_runmake release
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man6
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/opentyrian/data

	install -m 0755 opentyrian ${D}${bindir}
	install -m 0644 linux/man/opentyrian.6 ${D}${mandir}/man6
	install -m 0644 -T linux/icons/tyrian-48.png ${D}${datadir}/pixmaps/opentyrian.png
	install -m 0644 linux/opentyrian.desktop ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/tyrian21/* ${D}${datadir}/opentyrian/data
}

SRC_URI[data.md5sum] = "2a3b206a6de25ed4b771af073f8ca904"
SRC_URI[data.sha256sum] = "7790d09a2a3addcd33c66ef063d5900eb81cc9c342f4807eb8356364dd1d9277"
