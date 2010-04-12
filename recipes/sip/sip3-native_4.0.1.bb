DESCRIPTION = "SIP - A Python Wrapper Generator"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.vanille.de/mirror/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qmake native

EXTRA_QMAKEVARS_POST += "DESTDIR=${STAGING_BINDIR} CONFIG=console"

do_configure_prepend() {
	cat sipgen.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > sipgen.pro
}


SRC_URI[md5sum] = "a2aa4ef53cb4f18e7ce25bc2e123548e"
SRC_URI[sha256sum] = "98d9f4937924d99db716ef8d80ff25a83fdef294981a43c089e97c9394ed08a7"
