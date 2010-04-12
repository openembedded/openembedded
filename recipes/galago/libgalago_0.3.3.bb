DESCRIPTION =	"Galago is a desktop presence framework, designed to transmit presence information between programs."
HOMEPAGE =	"http://www.galago-project.org/"
LICENSE =	"LGPL"
DEPENDS = 	"gettext dbus glib-2.0"
PR =		"r1"


SRC_URI =	"http://www.galago-project.org/files/releases/source/${PN}/${P}.tar.gz \
		 file://no-check.patch;patch=1"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_includes
	install -d ${STAGING_LIBDIR}
	install -m 755 libgalago/.libs/libgalago.so.1.0.0 ${STAGING_LIBDIR}/libgalago.so
}

SRC_URI[md5sum] = "94d5223445deb1ed95973424d4958386"
SRC_URI[sha256sum] = "148bc83e4ab6e87a6f26b60efdffc1258752a42079783e6f2b080f287e8b15fc"
