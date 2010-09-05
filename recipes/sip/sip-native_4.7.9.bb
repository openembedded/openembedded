DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
AUTHOR = "Phil Thompson"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "ml1"

SRC_URI = "http://www.riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"
SRC_URI[md5sum] = "597d7ff7edb42a18421c806ffd18a136"
SRC_URI[sha256sum] = "7faaccb6f17296399051bd076a7f41e0f6d95a28eda3e30468f1bd7cf45898e1"

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
