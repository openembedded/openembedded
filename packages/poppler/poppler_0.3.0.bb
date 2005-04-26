DESCRIPTION = "Poppler is a PDF rendering library based on the xpdf-3.0 code base."
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPL"

DEPENDS = "jpeg gtk+ cairo"

SRC_URI="http://poppler.freedesktop.org/${PN}-${PV}.tar.gz"

EXTRA_OECONF = "--disable-gtk-test --disable-poppler-qt"  
inherit pkgconfig autotools

