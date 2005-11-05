DESCRIPTION = "GPE frontend for libfsi-client"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENCE = "gpl"

inherit gpe

SRC_URI = "http://dominion.kabel.utwente.nl/koen/pda/files/gpe-fsi.tar.bz2"
PR = "r1"

DEPENDS = "libgpewidget fsi-client gtk+"
SECTION = "gpe"

S ="${WORKDIR}/gpe-fsi"

do_compile() {
        oe_runmake all
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${libdir}
	install -d ${D}/usr/share/applications
	install -d ${D}/usr/share/pixmaps/
	install gpe-fsi ${D}${bindir}
	install gpe-fsi.desktop ${D}/usr/share/applications/
	install gpe-fsi.png ${D}/usr/share/pixmaps/
}

