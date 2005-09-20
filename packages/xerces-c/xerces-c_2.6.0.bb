PR = "r0"
DESCRIPTION = "Xerces-c xml"
SECTION =  "libs"
PRIORITY = "optional"
MAINTAINER = "Philip Balister philip@balister.org"
LICENSE = "MIT"

S="${WORKDIR}/xerces-c-src_2_6_0"

SRC_URI = "http://www.axint.net/apache/xml/xerces-c/xerces-c-src_2_6_0.tar.gz"

inherit pkgconfig 

do_compile () {
        export XERCESCROOT=${S}
        cd src/xercesc
# runConfigure is going to bust CC and CXX I bet
        CC_SAVE="${CC}"
        CXX_SAVE="${CXX}"
	./runConfigure -plinux -c${CC} -x${CXX} -minmem -nsocket -tnative -rpthread
        CC="${CC_SAVE}"
        CXX="${CXX_SAVE}"
        oe_runmake
}

do_stage () {
	oe_libinstall lib/libxerces-c ${STAGING_LIBDIR}
	oe_libinstall lib/libxerces-depdom ${STAGING_LIBDIR}

	cp -pPR include/xercesc ${STAGING_INCDIR}
}

do_install () {
	oe_libinstall lib/libxerces-c ${D}${libdir}
	oe_libinstall lib/libxerces-depdom ${D}${libdir}
}
