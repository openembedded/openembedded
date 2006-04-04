SECTION = "console/network"
DESCRIPTION = "Iperf is a tool to measure maximum TCP bandwidth, allowing the tuning of various parameters and UDP characteristics"
HOMEPAGE = "http://dast.nlanr.net/Projects/Iperf/"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://dast.nlanr.net/Projects/Iperf2.0/iperf-${PV}.tar.gz"
#	file://socketaddr-h-errno.diff;patch=1"

inherit autotools

S="${WORKDIR}/iperf-${PV}"

# --disable-threads is needed on epia/x86 with uclibc
do_configure() {
	oe_runconf --exec-prefix=${STAGING_DIR}  --disable-threads
}

do_compile() {
	cd ${WORKDIR}/iperf-${PV}
	oe_runmake
}

do_install() {
	cd ${WORKDIR}/iperf-${PV}/src
	oe_runmake DESTDIR=${D} install
}
