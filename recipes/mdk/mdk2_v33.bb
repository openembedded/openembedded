SECTION = "console/network"
DESCRIPTION = "ASPj is drunk"
HOMEPAGE = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/"
LICENSE = "GPLv2"
DEPENDS = ""
RDEPENDS = ""
PR ="r1"

SRC_URI = "http://homepages.tu-darmstadt.de/~p_larbig/wlan/mdk2-${PV}.tar.bz2 \
	   file://mdk2-ppcfix.patch"

LDFLAGS_append = " -lpthread"
CFLAGS_append = " -I${STAGING_KERNEL_DIR}/include -O3 -pthread"

oe_compile() {
        oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}"
}

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 mdk2       ${D}/${sbindir}
}

SRC_URI[md5sum] = "c02004f4588fdc19e5e861df896f5e2c"
SRC_URI[sha256sum] = "38294fb58a3dfcc21d64f263370d039a2411dda0aa472d1e0d94b7864f1f8fc9"
