inherit gpe

DEPENDS = "gtk+ libsvg-cairo"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r7"

SRC_URI += "file://splash-p.svg file://splash-l.svg \
            file://c7x0-rotation.patch;patch=1 \
            file://cxx0-rotation.patch;patch=1 \
            file://cairofix.patch;patch=1 \
            file://no-strip-on-install.patch;patch=1"

SRC_URI_append_mnci = " file://mnci.patch;patch=1"

FILES_${PN} += "${datadir}/gpe"

do_install_append() {
	install -m 0644 ${WORKDIR}/splash-p.svg ${D}${datadir}/gpe/splash-p.svg
	install -m 0644 ${WORKDIR}/splash-l.svg ${D}${datadir}/gpe/splash-l.svg
	mv ${D}${sysconfdir}/rcS.d/S00bootsplash ${D}${sysconfdir}/rcS.d/S03bootsplash
}

