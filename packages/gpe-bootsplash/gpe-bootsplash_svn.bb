SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libsvg-cairo"
PR = "r1"
PV = "1.15+svn-${SRCDATE}"

inherit autotools

SRC_URI += "${GPE_SVN} \
            file://splash-p.svg \
            file://splash-l.svg \
            file://init.patch;patch=1 \
	    file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"


do_install_append() {
        install -m 0644 ${WORKDIR}/splash-p.svg ${D}${datadir}/gpe/splash-gpe-portrait.svg
        install -m 0644 ${WORKDIR}/splash-l.svg ${D}${datadir}/gpe/splash-gpe-landscape.svg
        mv ${D}${sysconfdir}/rcS.d/S00bootsplash ${D}${sysconfdir}/rcS.d/S07bootsplash
}

FILES_${PN} += "${datadir}/gpe"

pkg_postinst() {
        update-alternatives --install /usr/share/gpe/splash-l.svg bootsplash-l /usr/share/gpe/splash-gpe-landscape.svg 10
        update-alternatives --install /usr/share/gpe/splash-p.svg bootsplash-p /usr/share/gpe/splash-gpe-portrait.svg 10
}
pkg_postrm() {
        update-alternatives --remove bootsplash-l /usr/share/gpe/splash-gpe-landscape.svg
        update-alternatives --remove bootsplash-p /usr/share/gpe/splash-gpe-portrait.svg
}

DEFAULT_PREFERENCE = "-1"
