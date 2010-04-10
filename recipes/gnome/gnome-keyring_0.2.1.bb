LICENSE = "GPL"
SECTION = "x11/gnome"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/${PN}/0.2/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

DEPENDS = ""

EXTRA_OECONF = "--disable-gtk-doc"

HEADERS = " \
gnome-keyring.h \
"

do_stage() {
	install -d ${STAGING_INCDIR}/gnome-keyring-1
	for i in ${HEADERS}; do
		install -m 0644 $i ${STAGING_INCDIR}/gnome-keyring-1/$i
	done
	oe_libinstall -so libgnome-keyring ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "2fe5fb39cc18d1a6792fd3281223dfff"
SRC_URI[sha256sum] = "1c6d5a1732742469ec32ab7297f3b8eacfc0f4bfae5fdb096b603877dde12612"
