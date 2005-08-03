SECTION = "console/network"
DESCRIPTION = "Iperf is a tool to measure maximum TCP bandwidth, allowing the tuning of various parameters and UDP characteristics"
HOMEPAGE = "http://dast.nlanr.net/Projects/Iperf/"
LICENSE = "BSD"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"

SRC_URI = "http://dast.nlanr.net/Projects/Iperf/iperf-${PV}-source.tar.gz \
	file://socketaddr-h-errno.diff;patch=1;pnum=0"

inherit autotools

S="${WORKDIR}/iperf-${PV}/cfg"
PATCHES_DIR="${WORKDIR}/iperf-${PV}"

do_configure() {
	oe_runconf
}

do_compile() {
	cd ${WORKDIR}/iperf-${PV}
	oe_runmake
}

do_install() {
	cd ${WORKDIR}/iperf-${PV}/src
	oe_runmake INSTALL_DIR=${D}${bindir} install
}
