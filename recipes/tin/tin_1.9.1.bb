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

SRC_URI[md5sum] = "50ecd901467622fbc47bc935aca222b3"
SRC_URI[sha256sum] = "0da9424503faad972860682107157d7348872f00f932ec270c78f17ee495dc97"
