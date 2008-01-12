DESCRIPTION = "Xerces-c is a validating xml parser written in C++"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "MIT"

SRC_URI = "http://mirror.serversupportforum.de/apache/xerces/c/sources/xerces-c-src_2_8_0.tar.gz"
S = "${WORKDIR}/xerces-c-src_2_8_0/src/xercesc"

inherit pkgconfig

CCACHE = ""
export XERCESCROOT="${WORKDIR}/xerces-c-src_2_8_0"

do_configure() {
	./runConfigure -plinux -c"${BUILD_CC}" -x"${BUILD_CXX}" -minmem -nsocket -tnative -rpthread -P${D}${prefix}
}

do_compile() {
	${MAKE}
}

do_stage () {
    oe_libinstall -C ${XERCESCROOT}/lib libxerces-c ${STAGING_LIBDIR}
    oe_libinstall -C ${XERCESCROOT}/lib libxerces-depdom ${STAGING_LIBDIR}
    cp -pPR ${XERCESCROOT}/include/xercesc ${STAGING_INCDIR}
}

do_install () {
	${MAKE} install
}
