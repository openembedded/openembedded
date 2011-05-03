DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
AUTHOR = "Phil Thompson"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"
SRC_URI[md5sum] = "0f8e8305b14c1812191de2e0ee22fea9"
SRC_URI[sha256sum] = "e9d66e8830c2a58e6c17b9952710f67d495ddb84ce6f3d89400c8b52913381b5"
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
