DESCRIPTION = "Driftnet watches network traffic, and picks out and displays JPEG and GIF \
images for display. It is an horrific invasion of privacy and shouldn't be used \
by anyone anywhere. It can also extract MPEG audio data from the network and \
play it."
SECTION = "net"
PRIORITY = "optional"

DEPENDS = "libpcap jpeg libungif"
PV = "0.1.6"

SRC_URI = "http://www.ex-parrot.com/~chris/driftnet/driftnet-${PV}.tar.gz \
	file://arm.patch;patch=1"

S = "${WORKDIR}/driftnet-${PV}"

inherit autotools

do_compile() {
	oe_runmake STAGING_INCDIR="${STAGING_INCDIR}"
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0744 driftnet ${D}/${bindir}/
}

SRC_URI[md5sum] = "8e11d77770452f97bb3c23f510489815"
SRC_URI[sha256sum] = "dbdf7ead3ae14b109f88c86dedeb7524be8c257aa773a781891216f013373d6d"
