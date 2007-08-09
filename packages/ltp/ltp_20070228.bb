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

