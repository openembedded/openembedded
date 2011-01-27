DESCRIPTION = "Linux Test Project"
HOMEPAGE = "http://ltp.sourceforge.net"
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "zip-native"
PR = "r0"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/ltp/ltp-full-${PV}.bz2 \
	  file://runalltests.patch"

S = "${WORKDIR}/ltp-full-${PV}"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${HOST_PREFIX} SKIP_IDCHECK=1"

FILES_${PN}-dbg += "/usr/.debug"
FILES_${PN}-dbg += "/usr/bin/.debug"
FILES_${PN}-dbg += "/usr/runtest/.debug"
FILES_${PN}-dbg += "/usr/testcases/bin/.debug"
FILES_${PN}-dbg += "/usr/testcases/bin/*/bin/.debug"
FILES_${PN}-dbg += "/usr/testcases/bin/*/test/.debug"

FILES_${PN} += "/usr/* /usr/bin/* /usr/runtest/* /usr/testcases/bin/* /usr/testcases/bin/*/bin/* /usr/runtest/* /usr/testscripts/*"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile(){
        oe_runmake CROSS_COMPILE=${HOST_PREFIX}
}

do_install(){
        oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "553e13e8f2b0cd75fa93f832a8f734a7"
SRC_URI[sha256sum] = "df8c7607f8887aafc51510c04966ecb91e52135e5a86298f73fd30c148960ce8"

