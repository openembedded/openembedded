DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
SECTION = "devel"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
AUTHOR = "Phil Thompson"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://cvs.fedora.redhat.com/repo/pkgs/sip/sip-4.7.7.tar.gz/9cabe6a0f61b73582cfc38b903576211/sip-4.7.7.tar.gz"
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

SRC_URI[md5sum] = "9cabe6a0f61b73582cfc38b903576211"
SRC_URI[sha256sum] = "928fa03d1b8a2329f5e71dd9190080146b5275119e28c19c36fdd57e788d84ba"
