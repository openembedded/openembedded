DEPENDS = "gtk+ glib-2.0 libgpewidget webkit-gtk"
PV = "0.0.1+svnr${SRCPV}"
PR = "r0"

SRCREV = "9819"

inherit autotools

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/gpe-mini-browser2"

do_install() {
                install -d ${D}/usr/share/applications
                install -m 0644 ${S}/gpe-mini-browser2.desktop ${D}/usr/share/applications/gpe-mini-browser2.desktop
                install -d ${D}/usr/share/pixmaps
                install -m 0644 ${S}/gpe-mini-browser2.png ${D}/usr/share/pixmaps/gpe-mini-browser2.png
                autotools_do_install
}

require gpe-mini-browser.inc

#DEFAULT_PREFERENCE = "-1"
