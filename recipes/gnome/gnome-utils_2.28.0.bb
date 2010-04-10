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



SRC_URI[archive.md5sum] = "156e38fdf348bf2db4fcb7b84ddcc2aa"
SRC_URI[archive.sha256sum] = "40c99392e6c06ff31d735c41cf285f02b7b8c0419f1954c533b7da900e7b9752"
