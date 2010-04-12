PR 	= "r2"
LICENSE =	""

DEPENDS = "gtk+-2.6.4-1.osso7 osso-gnome-vfs2"
SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/osso-thumbnail/osso-thumbnail_${PV}.tar.gz"

S = "${WORKDIR}/osso-thumbnail-0.3.1"

inherit pkgconfig autotools
EXTRA_OECONF =	"--disable-gtk-doc"


do_stage() {
	install -d ${STAGING_INCDIR}
	install -d ${STAGING_LIBDIR}
	install -m 644 thumbs/*.h ${STAGING_INCDIR}
	install thumbs/.libs/libossothumbnail.so ${STAGING_LIBDIR}
	install thumbs/.libs/libossothumbnail.so.0 ${STAGING_LIBDIR}
	install thumbs/.libs/libossothumbnail.so.0.0.3 ${STAGING_LIBDIR}
}



SRC_URI[md5sum] = "95d35782e17404fa4c4b634ed7cd898d"
SRC_URI[sha256sum] = "bec82e8b1b695f14403931a61ff438ebb62853a398598b540faabeea5fc774ad"
