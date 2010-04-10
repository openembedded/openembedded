DESCRIPTION = "Linux Test Project"
HOMEPAGE = "http://ltp.sourceforge.net"
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "zip-native"
PR = "r4"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/ltp/ltp-full-${PV}.tgz \
           file://cross-compile.patch;patch=1 \
           file://runltp-path.patch;patch=1 \
           file://fix-tcore_patch_test_suites.patch;patch=1 \
           file://no-IDcheck.patch;patch=1 \
           file://no_hyperthreading_tests.patch;patch=1 \
           file://syscalls.patch;patch=1"

SRC_URI_append_mips += "file://no_epoll_create2.patch;patch=1"
SRC_URI_append_mipsel += "file://no_epoll_create2.patch;patch=1"
SRC_URI_append_arm += "file://no_epoll_create2.patch;patch=1"
SRC_URI_append_armeb += "file://no_epoll_create2.patch;patch=1"

S = "${WORKDIR}/ltp-full-${PV}"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${HOST_PREFIX}"

FILES_${PN}-dbg  = "${libexecdir}/ltp/*/*/*/*/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/.debug"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile(){
        oe_runmake CROSS_COMPILE=${HOST_PREFIX}
}

do_install(){
        export CREATE=0
        export LTPROOT=${D}/usr/libexec/ltp/testcases

        oe_runmake DESTDIR=${D} PREFIX=/usr/libexec/ltp install

        install -d ${D}/usr/libexec/ltp/testcases
        install -d ${D}/usr/libexec/ltp/pan

        #install testcases 
        #install -m 0755 ${WORKDIR}/testcases ${D}/usr/libexec/ltp/testcases
        #install -m 0755 ${WORKDIR}/testcases ${D}/usr/libexec/ltp/
        
        # treecopy testcases pan/pan runtest ver_linux IDcheck.sh \
        # ${D}/usr/libexec/ltp
        cp testcases    ${D}/usr/libexec/ltp/ -rfp
        rm              ${D}/usr/libexec/ltp/testcases/ballista -rf
        cp pan/pan      ${D}/usr/libexec/ltp/pan -p
        cp runtest      ${D}/usr/libexec/ltp/ -rfp
        cp ver_linux    ${D}/usr/libexec/ltp/ -p
        cp runltp       ${D}/usr/libexec/ltp/ -p
        cp IDcheck.sh   ${D}/usr/libexec/ltp/ -p

	# We don't want "devel" stuff
	rm -rf ${D}/opt/ltp/include
	rm ${D}/usr/libexec/ltp/share/pkgconfig/ltp.pc
}


SRC_URI[md5sum] = "397b376dd659459e4a431474b42263a8"
SRC_URI[sha256sum] = "5fa4353d826b719cc313e370dd8f4ab0793432e4d797a96cb5bb01e078ff1e10"
