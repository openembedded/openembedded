LICENSE =	""
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = 	"gtk+-2.6.4-1.osso7 osso-gnome-vfs2"
SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/osso-thumbnail/osso-thumbnail_${PV}.tar.gz"
S = 	"${WORKDIR}/osso-thumbnail-0.3.1"

inherit pkgconfig autotools
EXTRA_OECONF =	"--disable-gtk-doc"


do_install_prepend() {
	install -d ${D}/${libdir}
	install thumbs/.libs/libossothumbnail.so.0.0.3 ${D}${libdir}/
}

do_stage() {
	install -d ${STAGING_INCDIR}
	install -d ${STAGING_LIBDIR}
	install -m 644 thumbs/*.h ${STAGING_INCDIR}
	install thumbs/.libs/libossothumbnail.so ${STAGING_LIBDIR}
	install thumbs/.libs/libossothumbnail.so.0 ${STAGING_LIBDIR}
	install thumbs/.libs/libossothumbnail.so.0.0.3 ${STAGING_LIBDIR}
}


