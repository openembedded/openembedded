DESCRIPTION = "OBEX Ftp Client based on openobex."
SECTION = "console/network"
HOMEPAGE = "http://dev.zuckschwerdt.org/openobex/wiki/ObexFtp"
LICENSE = "GPL"
DEPENDS = "openobex bluez-libs virtual/libusb0 virtual/libiconv"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/obexftp-${PV}.tar.bz2 \
	  "

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

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


