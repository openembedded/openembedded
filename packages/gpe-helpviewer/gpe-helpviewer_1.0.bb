PR = "r1"

SRC_URI = "http://stag.mind.be/gpe-helpviewer.tar.bz2"

DEPENDS = "gtkhtml-3.0 gpe-helpviewer-${PN}-doc"

S = "${WORKDIR}/gpe-helpviewer"

inherit autotools

do_install() {
		install -d ${D}${docdir}/gpe-helpviewer
		install -m 0644 ${S}/gpe-helpviewer.html  ${D}${docdir}/gpe-helpviewer
		install -d ${D}/usr/share/applications
		install -m 0644 ${S}/gpe-helpviewer.desktop ${D}/usr/share/applications/gpe-helpviewer.desktop
		install -d ${D}/usr/share/pixmaps
		install -m 0644 ${S}/gpe-help.png ${D}/usr/share/pixmaps/gpe-help.png
		autotools_do_install
}
