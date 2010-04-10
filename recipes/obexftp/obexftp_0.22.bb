DESCRIPTION = "OBEX Ftp Client based on openobex."
SECTION = "console/network"
HOMEPAGE = "http://dev.zuckschwerdt.org/openobex/wiki/ObexFtp"
LICENSE = "GPL"
DEPENDS = "openobex bluez-libs virtual/libusb0 virtual/libiconv"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/obexftp-${PV}.tar.bz2 \
	  "

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-bluetooth \
		 --disable-swig \
		 --disable-perl \
		 --disable-python \
		 --disable-tcl \
		 --disable-ruby \
		 --disable-builddocs \
		 --disable-rpath \
		"

PARALLEL_MAKE = ""

LEAD_SONAME = "libobexftp.so"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "d167cfdea244e3a5f973a7b16864419c"
SRC_URI[sha256sum] = "09687012d5e016277fa638f22b8c784aea6803056c70d14614e3b75158aae877"
