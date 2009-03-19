DESCRIPTION = "OBEX Ftp Client based on openobex."
SECTION = "console/network"
HOMEPAGE = "http://openobex.triq.net"
LICENSE = "GPL"
DEPENDS = "openobex libgsm"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/obexftp-${PV}.tar.gz \
	   file://iconv.patch;patch=1 \
	   file://i-hate-libtool.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF += "--enable-bluetooth --disable-swig --disable-perl --disable-python --disable-tcl --disable-builddocs --disable-rpath"

PARALLEL_MAKE = ""

do_stage() {
	autotools_stage_all
}

