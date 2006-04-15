DESCRIPTION = "Poppler is a PDF rendering library based on the xpdf-3.0 code base."
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "fontconfig jpeg gtk+ cairo"

SRC_URI="http://poppler.freedesktop.org/${PN}-${PV}.tar.gz"

EXTRA_OECONF = "--enable-xpdf-headers  --disable-gtk-test --disable-poppler-qt"  
inherit pkgconfig autotools


do_stage() {
	autotools_stage_all
}


