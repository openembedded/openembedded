DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
SECTION = "devel"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
AUTHOR = "Phil Thompson"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "ml0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.riverbankcomputing.co.uk/static/Downloads/sip4/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qt4x11 native

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

EXTRA_QMAKEVARS_POST += "DESTDIR=${S} CONFIG=console"

do_configure_prepend() {
	cat sipgen.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > sipgen.pro
}

do_stage() {
	install -m 0755 sip ${STAGING_BINDIR_NATIVE}/sip
	cd ${WORKDIR}/sip-${PV} && python configure.py
	install -d ${STAGING_PYDIR}/site-packages
	install -m 0755 sip*.py ${STAGING_PYDIR}/site-packages
}

SRC_URI[md5sum] = "597d7ff7edb42a18421c806ffd18a136"
SRC_URI[sha256sum] = "7faaccb6f17296399051bd076a7f41e0f6d95a28eda3e30468f1bd7cf45898e1"
