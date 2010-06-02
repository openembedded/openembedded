DESCRIPTION = "4DIAC-RTE (FORTE) is a small portable implementation of an IEC 61499 runtime environment"
HOMEPAGE = "http://www.fordiac.org/8.0.html"
SECTION = "console/network"
DEPENDS = ""
RDEPENDS_${PN} = ""
LICENSE = "EPL"

inherit autotools

EXTRA_OEMAKE = 'LIBS+="-lpthread" CXXFLAGS+="-O0 -g" CPPFLAGS+="-DLOGDEBUG -I${S}/src/core -I${S}/src/core/datatypes -I${S}/src/fblib/events -I${S}/src/fblib/ita -I${S}/src/fblib/math -I${S}/src/fblib/net"'

do_configure_prepend() {
	chmod +x ${S}/configure
	ln -s -f ${S}/src/arch/pc ${S}/src/arch/active_arch
}
