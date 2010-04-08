DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf"

inherit gnome pkgconfig

SRC_URI += "file://no-try-run-strftime.diff;patch=1"
SRC_URI[archive.md5sum] = "c6d779ddccf99cbe0667b578078dd011"
SRC_URI[archive.sha256sum] = "745bb25fce536dc5337e7b5cbcbce9eee66b3cc0c500de302759b98ebcef6a8f"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_append() {
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done
}

FILES_${PN} += "${datadir}/baobab \
                ${datadir}/gdict-1.0 \
                ${datadir}/gnome-dictionary \
                ${datadir}/gnome-screenshot \
               "


