DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
AUTHOR = "Phil Thompson"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"
SRC_URI[md5sum] = "8a0998fbaf34bdab2c15af3d4fa3bc0e"
SRC_URI[sha256sum] = "9a0d24aec5328fd038be13f94de5c710b767caeb1dfd869e52c69d98b8656168"

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

DEFAULT_PREFERENCE = "-1"
NATIVE_INSTALL_WORKS = "1"
