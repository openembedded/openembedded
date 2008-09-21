DESCRIPTION = "GTK+ based simple text editor"
HOMEPAGE = "http://tarot.freeshell.org/leafpad"
AUTHOR = "Tarot Osuji <tarot@sdf.lonestar.org>"
SECTION = "x11/applications"
LICENSE = "GPLv2"
DEPENDS = "gtk+"
SRC_URI = "http://savannah.nongnu.org/download/${PN}/${PN}-${PV}.tar.gz \
           file://leafpad.desktop \
           file://leafpad.png"
PR = "r0"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-chooser --enable-emacs --disable-print"

do_install_append () {
        install -d ${D}/${datadir}
        install -d ${D}/${datadir}/applications
        install -d ${D}/${datadir}/pixmaps/

        install -m 0644 ${WORKDIR}/leafpad.png ${D}/${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/leafpad.desktop ${D}/${datadir}/applications
}

FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps ${datadir}/icons"
