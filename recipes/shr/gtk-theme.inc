RPROVIDES_${PN} += "virtual/theme-gtk"
RDEPENDS_${PN} = "gtk+"
SECTION = "gtk"

SRC_URI += "file://gtkrc"

do_install() {
	install -d "${D}${datadir}/themes/${PN}/gtk-2.0"
	cp -R "${S}/./" "${D}${datadir}/themes/${PN}/gtk-2.0"
        install -d ${D}${sysconfdir}/gtk-2.0/
        install -m 0644 ${WORKDIR}/gtkrc ${D}${sysconfdir}/gtk-2.0/gtkrc.${PN}
}

PACKAGES += "${PN}-gtkrc"
FILES_${PN} = "${datadir}/themes/${PN}/"
FILES_${PN}-gtkrc = "${sysconfdir}/gtk-2.0/gtkrc.${PN}"
RDEPENDS_${PN} += "${PN}-gtkrc"

pkg_postinst_${PN}-gtkrc () {
        update-alternatives --install ${sysconfdir}/gtk-2.0/gtkrc gtk-theme ${sysconfdir}/gtk-2.0/gtkrc.${PN} 10
}
pkg_prerm_${PN}-gtkrc () {
        update-alternatives --remove gtk-theme ${sysconfdir}/gtk-2.0/gtkrc.${PN}
}
