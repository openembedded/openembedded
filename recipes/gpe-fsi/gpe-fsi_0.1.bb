DESCRIPTION = "GPE frontend for libfsi-client"
LICENSE = "gpl"

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


SRC_URI[md5sum] = "e485b0c8424dc9666078d482d22447da"
SRC_URI[sha256sum] = "6a7455e4a066d5ecd9520feb9cd7bb1a7ecfe267faef32cd04a97b5c1738f8ec"
