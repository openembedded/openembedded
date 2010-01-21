inherit gpe

DEPENDS = "gtk+ libsvg-cairo"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r10"

SRC_URI += "file://splash-p.svg \
	    file://splash-l.svg \
	    file://init.patch;patch=1 \
	    file://no-strip-on-install.patch;patch=1"


FILES_${PN} += "${datadir}/gpe"

do_install_append() {
	install -m 0644 ${WORKDIR}/splash-p.svg ${D}${datadir}/gpe/splash-gpe-portrait.svg
	install -m 0644 ${WORKDIR}/splash-l.svg ${D}${datadir}/gpe/splash-gpe-landscape.svg
	mv ${D}${sysconfdir}/rcS.d/S00bootsplash ${D}${sysconfdir}/rcS.d/S07bootsplash
}

pkg_postinst() {

	update-alternatives --install /usr/share/gpe/splash-l.svg bootsplash-l /usr/share/gpe/splash-gpe-landscape.svg 10
	update-alternatives --install /usr/share/gpe/splash-p.svg bootsplash-p /usr/share/gpe/splash-gpe-portrait.svg 10
}

pkg_postrm() {
	update-alternatives --remove bootsplash-l /usr/share/gpe/splash-gpe-landscape.svg
	update-alternatives --remove bootsplash-p /usr/share/gpe/splash-gpe-portrait.svg
}
