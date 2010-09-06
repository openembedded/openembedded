DESCRIPTION = "Linux Test Project"
HOMEPAGE = "http://ltp.sourceforge.net"
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "zip-native"
PR = "r0"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/ltp/ltp-full-${PV}.tgz"

S = "${WORKDIR}/ltp-full-${PV}"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${HOST_PREFIX} SKIP_IDCHECK=1"

FILES_${PN}-dbg = "/usr/.debug"
FILES_${PN}-dbg = "/usr/bin/.debug"
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

SRC_URI[md5sum] = "fc5a36a7dcc8f7d5fa7b34dd4f43f25b"
SRC_URI[sha256sum] = "c0ce2599ea0daf94b6259ba8fdbdd4cf42c7a3424314974df16fcb4c4599aed2"

