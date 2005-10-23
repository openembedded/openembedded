PR = "r0"

SRC_URI      = "${GPE_MIRROR}/gpe-mini-browser-${PV}.tar.gz"
DESCRIPTION  = "A lightweight webbrowser for the GPE platform (Hildon UI)"
LICENSE      = "GPL"
DEPENDS      = "osb-nrcit libosso hildon-lgpl hildon-fm libgpewidget"
EXTRA_OECONF = "--enable-hildon"

S = "${WORKDIR}/gpe-mini-browser-${PV}"

inherit autotools

do_install() {
		install -d ${D}/usr/share/applications/hildon
		install -m 0644 ${S}/hildon/gpe-mini-browser.desktop ${D}/usr/share/applications/hildon/gpe-mini-browser.desktop
		install -d ${D}/usr/share/pixmaps
		install -m 0644 ${S}/gpe-mini-browser.png ${D}/usr/share/pixmaps/gpe-mini-browser.png
		autotools_do_install
}


