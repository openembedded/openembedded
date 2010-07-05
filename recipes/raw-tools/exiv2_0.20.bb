DESCRIPTION = "Exiv2 is a C++ library and a command line utility to access image metadata."
LICENSE = "GPLv2+"
DEPENDS = "tiff zlib" 

SRC_URI = "http://www.exiv2.org/exiv2-${PV}.tar.gz"
SRC_URI[md5sum] = "3173d08a4313dc94b7bd1b7cdbda2093"
SRC_URI[sha256sum] = "7485f252c18119e61cdf1d73487bf0c5e3da6707decd6238407504847b323972"

inherit autotools lib_package

do_install_append() {
	for pc in $(find ${D} -name "*.pc") ; do
		sed -i 's:-Wl,-rpath-link,${STAGING_LIBDIR}::g' $pc
		sed -i 's:-L${STAGING_LIBDIR}::g' $pc
	done
}

