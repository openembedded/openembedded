HOMEPAGE = "http://alumnit.ca/wiki/index.php?page=WvStreams"
LICENSE = "LGPL"
DESCRIPTION = "WvStreams is a network programming library in C++"
DEPENDS = "zlib openssl (>= 0.9.8)"

SRC_URI = "http://wvstreams.googlecode.com/files/${PN}-${PV}.tar.gz \
           file://build-fixes-and-sanity.patch;patch=1 "

inherit autotools

LDFLAGS_append = " -Wl,-rpath-link,${CROSS_DIR}/${TARGET_SYS}/lib"

EXTRA_AUTORECONF += " -I${S}/gnulib/m4"
EXTRA_OECONF = " --without-tcl --without-qt --without-pam"


