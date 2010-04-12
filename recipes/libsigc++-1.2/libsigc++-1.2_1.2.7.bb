DESCRIPTION = "A library for loose coupling of C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"
PR = "r0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/libsigc++/1.2/libsigc++-${PV}.tar.bz2 \
	   file://autofoo.patch;patch=1 \
           file://disable-tests.patch;patch=1"
S = "${WORKDIR}/libsigc++-${PV}"

inherit autotools pkgconfig

# FIXME: Check why tests don't compile

acpaths = ""

do_stage() {
	install -d ${STAGING_LIBDIR}/sigc++-1.2/include
	install -m 0644 sigc++/config/sigcconfig.h ${STAGING_LIBDIR}/sigc++-1.2/include/
	oe_libinstall -so -C sigc++ libsigc-1.2 ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/sigc++-1.2/sigc++
	for f in sigc++/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/sigc++-1.2/sigc++/
	done
}

FILES_${PN}-dev += "${libdir}/sigc++-*/"

SRC_URI[md5sum] = "212f48536019e1f003d2509b4c9b36df"
SRC_URI[sha256sum] = "d9163d90e259bfde9164c7b218475a7664a7907a1b3197f17bc1035f36112225"
