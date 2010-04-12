DESCRIPTION = "Linux Test Project"
HOMEPAGE = "http://ltp.sourceforge.net"
LICENSE = "GPL"
SECTION = "console/utils"

SRC_URI = "${SOURCEFORGE_MIRROR}/ltp/ltp-full-${PV}.tgz \
           file://cross-compile.patch;patch=1 \
           file://runltp-path.patch;patch=1 \
           file://ltp-run"

S = "${WORKDIR}/ltp-full-${PV}"

EXTRA_OEMAKE_append = " CROSS_COMPILE=${HOST_PREFIX}"

FILES_${PN}-dbg =  "${libexecdir}/ltp/*/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/*/.debug"
FILES_${PN}-dbg += "${libexecdir}/ltp/*/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/float/trigo/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/float/iperb/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/float/exp_log/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/float/power/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/float/bessel/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/abs/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/atof/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/nextafter/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/math/fptests/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/f00f/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/misc/crash/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/pan/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/network/ipv6/*/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/network/rpc/rpc01/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/bin/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/kernel/syscalls/*/.debug"
#FILES_${PN}-dbg += "${libexecdir}/ltp/testcases/kernel/mem/*/.debug"

do_compile(){
        oe_runmake CROSS_COMPILE=${HOST_PREFIX}
}

do_install(){
        export CREATE=0
        export LTPROOT=${D}/usr/libexec/ltp/testcases

        oe_runmake install

        install -d ${D}/usr/libexec/ltp/testcases
        install -d ${D}/usr/libexec/ltp/pan

        #install testcases 
        #install -m 0755 ${WORKDIR}/testcases ${D}/usr/libexec/ltp/testcases
        #install -m 0755 ${WORKDIR}/testcases ${D}/usr/libexec/ltp/
        
        # treecopy testcases pan/pan runtest ver_linux IDcheck.sh \
        # ${D}/usr/libexec/ltp
        cp testcases    ${D}/usr/libexec/ltp/ -rfp
        rm              ${D}/usr/libexec/ltp/ballista -rf
        cp pan/pan      ${D}/usr/libexec/ltp/pan -p
        cp runtest      ${D}/usr/libexec/ltp/ -rfp
        cp ver_linux    ${D}/usr/libexec/ltp/ -p
        cp runltp       ${D}/usr/libexec/ltp/ -p
        cp IDcheck.sh   ${D}/usr/libexec/ltp/ -p
}


SRC_URI[md5sum] = "afd35e0770f28121a9f8d6093d20a62b"
SRC_URI[sha256sum] = "bfc8cf4258574b48d33e9d622627db496e6533a469a6a87fd7ed76098dabb8a6"
