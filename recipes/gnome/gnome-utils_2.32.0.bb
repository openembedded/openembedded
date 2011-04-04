DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf"

inherit gnome pkgconfig

SRC_URI += "file://no-try-run-strftime.diff"

SRC_URI[archive.md5sum] = "e150cdb53314fe97ea80768850c2e03c"
SRC_URI[archive.sha256sum] = "033a55cf442096b28ea6292043354feafe000d1e5f4ebb962a9b6d72eb9a93fa"

do_configure_append() {
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done

        for i in ${S}/*/Makefile.am ; do
            sed -i -e 's: help::g' $i
        done
}

FILES_${PN} += "${datadir}/baobab \
                ${datadir}/gdict-1.0 \
                ${datadir}/gnome-dictionary \
                ${datadir}/gnome-screenshot \
               "


