DESCRIPTION = "A GPE Phone Edition theme for gpe-bootsplash"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gpe-bootsplash"
RDEPENDS = "gpe-bootsplash"
PR = "r0"

export THEME = "gpephone"

SRC_URI = "file://splash-${THEME}-portrait.svg \
           file://splash-${THEME}-landscape.svg"

do_install() {
	install -d "${D}${datadir}/gpe"
	install -m 0644 ${WORKDIR}/splash-${THEME}* ${D}${datadir}/gpe
}

pkg_postinst() {
	update-alternatives --install /usr/share/gpe/splash-l.svg bootsplash-l /usr/share/gpe/splash-${THEME}-landscape.svg 20
	update-alternatives --install /usr/share/gpe/splash-p.svg bootsplash-p /usr/share/gpe/splash-${THEME}-portrait.svg 20
}

pkg_postrm() {
	update-alternatives --remove bootsplash-l /usr/share/gpe/splash-${THEME}-landscape.svg
	update-alternatives --remove bootsplash-p /usr/share/gpe/splash-${THEME}-portrait.svg
}

FILES_${PN} = "/usr/share/gpe/splash-${THEME}-*"
