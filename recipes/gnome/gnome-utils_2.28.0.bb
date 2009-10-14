DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf"

inherit gnome pkgconfig

SRC_URI += "file://no-try-run-strftime.diff;patch=1"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_append() {
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done
}

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/baobab \
                ${datadir}/gdict-1.0 \
                ${datadir}/gnome-dictionary \
                ${datadir}/gnome-screenshot \
               "


