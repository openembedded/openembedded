DESCRIPTION = "Tin is a powerful text mode news reader."
SECTION = "console/network"
DEPENDS = "ncurses pcre"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "ftp://ftp.tin.org/pub/news/clients/tin/unstable/tin-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools 

PARALLEL_MAKE = ""
EXTRA_OECONF = "--with-screen=ncurses --with-pcre=${STAGING_LIBDIR}/.."

export BUILD_CFLAGS += "-I${S}/include -DHAVE_CONFIG_H"

do_configure() {
	oe_runconf
}

do_compile() {
	cd src && oe_runmake
}
