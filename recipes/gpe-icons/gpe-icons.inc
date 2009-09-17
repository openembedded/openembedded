SECTION = "gpe"
RDEPENDS += "gdk-pixbuf-loader-png"

inherit update-alternatives

ALTERNATIVE_NAME = "gpe-pixmaps"
ALTERNATIVE_LINK = "${datadir}/gpe/pixmaps"
ALTERNATIVE_PATH = "${datadir}/gpe/pixmaps.${PN}"
ALTERNATIVE_PRIORITY ?= 1

pkg_postinst() {
        if [[ -e /usr/share/gpe/pixmaps && ! -h /usr/share/gpe/pixmaps ]] ; then
                echo "Removing old /usr/share/gpe/pixmaps directory. Will be replaced with link managed by update-alternatives"
                echo "Press enter to continue"
                read
                rm -rf /usr/share/gpe/pixmaps
        fi
}
