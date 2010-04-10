require gpe-mini-browser.inc

PR = "r0"

SRC_URI      = "${GPE_MIRROR}/gpe-mini-browser-${PV}.tar.gz"
DESCRIPTION  = "A lightweight webbrowser for the GPE platform (Hildon UI)"
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



SRC_URI[md5sum] = "749c571ec28e2ea4f31602f3d5609e4b"
SRC_URI[sha256sum] = "19d345571344f65e35b06c3faad6cfc86afeb8a41533d39bfbf364e1da34188c"
