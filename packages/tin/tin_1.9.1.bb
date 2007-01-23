require tin.inc

PR = "r1"

SRC_URI = "ftp://ftp.tin.org/pub/news/clients/tin/v1.9/tin-${PV}.tar.gz \
	   file://m4.patch;patch=1"

PARALLEL_MAKE = ""

export BUILD_CFLAGS += "-I${S}/include -DHAVE_CONFIG_H"

do_configure() {
	oe_runconf
}

do_compile() {
	cd src && oe_runmake
}
