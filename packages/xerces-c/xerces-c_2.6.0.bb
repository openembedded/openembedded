DESCRIPTION = "Xerces-c xml"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"

S = "${WORKDIR}/xerces-c-src_2_6_0"

SRC_URI = "http://www.axint.net/apache/xml/xerces-c/xerces-c-src_2_6_0.tar.gz"

inherit pkgconfig


#
# Warning: BITSTOBUILD will default to 32 bits
#
export TRANSCODER="NATIVE"
export MESSAGELOADER="INMEM"
export NETACCESSOR="Socket"
export THREADS="pthread"
export BITSTOBUILD="32"
export LIBS = " -lpthread "
CFLAGS_append = " -DPROJ_XMLPARSER -DPROJ_XMLUTIL -DPROJ_PARSERS -DPROJ_SAX4C -DPROJ_SAX2 -DPROJ_DOM -DPROJ_DEPRECATED_DOM -DPROJ_VALIDATORS -DXML_USE_NATIVE_TRANSCODER -DXML_USE_INMEM_MESSAGELOADER -DXML_USE_PTHREADS -DXML_USE_NETACCESSOR_SOCKET "
CXXFLAGS_append = " -DPROJ_XMLPARSER -DPROJ_XMLUTIL -DPROJ_PARSERS -DPROJ_SAX4C -DPROJ_SAX2 -DPROJ_DOM -DPROJ_DEPRECATED_DOM -DPROJ_VALIDATORS -DXML_USE_NATIVE_TRANSCODER -DXML_USE_INMEM_MESSAGELOADER -DXML_USE_PTHREADS -DXML_USE_NETACCESSOR_SOCKET "

do_configure() {
    export XERCESCROOT=${S}
    cd src/xercesc
    ./configure
}

do_compile () {
    export XERCESCROOT=${S}
    cd src/xercesc
    oe_runmake
}

do_stage () {
    oe_libinstall -C lib libxerces-c ${STAGING_LIBDIR}
    oe_libinstall -C lib libxerces-depdom ${STAGING_LIBDIR}

    cp -pPR include/xercesc ${STAGING_INCDIR}
}

do_install () {
    oe_libinstall -C lib libxerces-c ${D}${libdir}
    oe_libinstall -C lib libxerces-depdom ${D}${libdir}
}
