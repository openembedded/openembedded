RPROVIDES_${PN} += "virtual/theme-gtk"
RDEPENDS = "gtk+"
SECTION = "gtk"

inherit update-alternatives

SRC_URI += "file://gtk-theme/gtkrc.${PN}"

do_install() {
	install -d "${D}${datadir}/themes/${PN}/gtk-2.0"
	cp -r "${S}/./" "${D}${datadir}/themes/${PN}/gtk-2.0"
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
        if [[ -e ${ALTERNATIVE_LINK} && ! -h ${ALTERNATIVE_LINK} ]] ; then
                echo "warn: ${ALTERNATIVE_LINK} exists and it's not a link!"
                echo "warn: It will be replaced with link managed by update-alternatives"
                echo "warn: Moving ${ALTERNATIVE_LINK} to ${ALTERNATIVE_LINK}.old."
                echo "warn: It should be empty but probably isn't!"
                echo "warn: Check what's left there and remove it manually."
                mv -f ${ALTERNATIVE_LINK} ${ALTERNATIVE_LINK}.old
        fi
}
