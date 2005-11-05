DESCRIPTION = "Poppler is a PDF rendering library based on the xpdf-3.0 code base."
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPL"

DEPENDS = "jpeg gtk+ cairo"

SRC_URI="http://poppler.freedesktop.org/${PN}-${PV}.tar.gz"

EXTRA_OECONF = "--disable-gtk-test --disable-poppler-qt"  
inherit pkgconfig autotools


do_stage() {
	autotools_stage_includes
	install -d ${STAGING_LIBDIR}
	install -m 755 poppler/.libs/libpoppler.so.0.0.0 ${STAGING_LIBDIR}/libpoppler.so
	install -m 755 glib/.libs/libpoppler-glib.so.0.0.0 ${STAGING_LIBDIR}/libpoppler-glib.so

}


