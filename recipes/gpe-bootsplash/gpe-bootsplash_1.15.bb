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

SRC_URI[md5sum] = "205b47792c4adc4e1d07d6e4ce8cc466"
SRC_URI[sha256sum] = "586c4635a104e6566284d5edf5d64fbd6d944a92b5c1b493baf16e78db540060"
