DESCRIPTION = "libSpiff brings XSPF playlist reading and writing support to your C++ application."
HOMEPAGE = "http://libspiff.sf.net"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "expat liburiparser"

SRC_URI = "${SOURCEFORGE_MIRROR}/libspiff/libspiff-${PV}.tar.bz2 \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/libspiff-${PV}"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "\
  --with-expat=${STAGING_LIBDIR}/.. \
  --with-uriparser=${STAGING_LIBDIR}/.. \
"

CPPFLAGS += "-I${S}/include"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "e6505bdff9048bf61533c00caf48d553"
SRC_URI[sha256sum] = "8451c7182a99f0f4a88b3c19234c5182689f91444c50fcb510452b5e5b8a7805"
