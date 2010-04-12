DESCRIPTION = "A library for loose coupling of C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
PR = "r1"
LICENSE = "GPL LGPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/libsigc/libsigc++-${PV}.tar.gz \
	   file://autofoo.patch;patch=1 \
	   file://pkgconfig.patch;patch=1"
S = "${WORKDIR}/libsigc++-${PV}"

inherit autotools pkgconfig

FILES_${PN}-dev += "${libdir}/sigc++-*/"

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


SRC_URI[md5sum] = "d0d1ffcae0eced97ef4f17ce0ba81352"
SRC_URI[sha256sum] = "dcd6d3ea9a2c185b5286f80eefe9ac1402036b8fa21cfc742442d99579bd2b3e"
