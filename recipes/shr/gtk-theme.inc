RPROVIDES_${PN} += "virtual/theme-gtk"
RDEPENDS = "gtk+"
SECTION = "gtk"

inherit update-alternatives

SRC_URI += "file://gtk-theme/gtkrc.${PN}"

do_install() {
	install -d "${D}${datadir}/themes/${PN}/gtk-2.0"
	cp -r "${S}/" "${D}${datadir}/themes/${PN}/gtk-2.0"
        install -d ${D}${sysconfdir}/gtk-2.0/
        install -m 0644 ${WORKDIR}/gtk-theme/gtkrc.${PN} ${D}${sysconfdir}/gtk-2.0/gtkrc.${PN}
}

FILES_${PN} = "${datadir}/themes/${PN}/ \
               ${sysconfdir}/gtk-2.0/gtkrc.${PN} \
              "

ALTERNATIVE_NAME = "gtk-theme"
ALTERNATIVE_LINK = "${sysconfdir}/gtk-2.0/gtkrc"
ALTERNATIVE_PATH = "${sysconfdir}/gtk-2.0/gtkrc.${PN}"

pkg_postinst() {
        if [[ -e /etc/gtk-2.0/gtkrc && ! -h /etc/gtk-2.0/gtkrc ]] ; then
                echo "Removing file /etc/gtk-2.0/gtkrc, will be replaced with link managed by update-alternatives"
                echo "Press enter to continue"
                read
                rm -f /etc/gtk-2.0/gtkrc
        fi
}
