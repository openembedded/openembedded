inherit gpe

DEPENDS = "gtk+ libsvg-cairo"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI += "file://splash-p.svg file://splash-l.svg"

FILES_${PN} += "${datadir}/gpe"

do_install_append() {
	install -m 0644 ${WORKDIR}/splash-p.svg ${D}${datadir}/gpe/splash-p.svg
	install -m 0644 ${WORKDIR}/splash-l.svg ${D}${datadir}/gpe/splash-l.svg
	mv ${D}/etc/rcS.d/S00bootsplash ${D}/etc/rcS.d/S02bootsplash
}

