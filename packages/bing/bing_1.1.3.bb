DESCRIPTION = "bing is an application which measures the RAW bandwidth of a remote network link."
SECTION = "console/network"
HOMEPAGE = "http://fgouget.free.fr/bing/index-en.shtml"
LICENSE = "GPL"

SRC_URI = "http://fgouget.free.fr/bing/bing_src-${PV}.tar.gz"
S = "${WORKDIR}/bing_src-${PV}"

CFLAGS += "-I${S}/include"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bing ${D}${bindir}
}
