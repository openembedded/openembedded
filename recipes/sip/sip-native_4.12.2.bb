DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
AUTHOR = "Phil Thompson"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"
SRC_URI[md5sum] = "9df80f88e0e4022cdd8a8891c6c38048"
SRC_URI[sha256sum] = "3e42bea028a1713558b5b8a317af4195d3b0feaa6c179d99401a7048f1a3cec4"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qt4x11 native python-dir

EXTRA_QMAKEVARS_POST += "DESTDIR=${S} CONFIG=console"

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

do_configure_prepend() {
        cat sipgen.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > sipgen.pro
}
do_install() {
        install -d ${D}${bindir}
        install -m 0755 sip ${D}${bindir}/sip
        cd ${WORKDIR}/sip-${PV} && python configure.py
        install -d ${D}${PYTHON_SITEPACKAGES_DIR}
        install -m 0755 sip*.py ${D}${PYTHON_SITEPACKAGES_DIR}
}

NATIVE_INSTALL_WORKS = "1"
