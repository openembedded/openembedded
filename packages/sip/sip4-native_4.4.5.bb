DESCRIPTION = "SIP is a C++/Python Wrapper Generator"
SECTION = "base"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
AUTHOR = "Phil Thompson"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.riverbankcomputing.com/Downloads/sip4/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qmake native

EXTRA_QMAKEVARS_POST += "DESTDIR=${S} CONFIG=console"

do_configure_prepend() {
	cat sipgen.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > sipgen.pro
}

do_stage() {
	install -m 0755 sip ${STAGING_BINDIR}/sip4
	cd ${WORKDIR}/sip-${PV} && python configure.py
	install -d ${STAGING_PYDIR}/site-packages
	install -m 0755 sip*.py ${STAGING_PYDIR}/site-packages
}

