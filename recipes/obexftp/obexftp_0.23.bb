DESCRIPTION = "OBEX Ftp Client based on openobex."
SECTION = "console/network"
HOMEPAGE = "http://dev.zuckschwerdt.org/openobex/wiki/ObexFtp"
LICENSE = "GPLv2/LGPLv2"
DEPENDS = "openobex bluez-libs virtual/libusb0 virtual/libiconv"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/obexftp-${PV}.tar.bz2 \
	  "

inherit autotools

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


SRC_URI[md5sum] = "f20762061b68bc921e80be4aebc349eb"
SRC_URI[sha256sum] = "44a74ff288d38c0f75354d6bc2efe7d6dec10112eaff2e7b10e292b0d2105b36"
