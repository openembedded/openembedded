SECTION = "console/network"
DESCRIPTION = "FakeConnect is a application/network stress-test program."
LICENSE = "BSD"

SRC_URI = "http://www.hostname.org/fake_connect/fakeconnect-${PV}.tar.gz"
S = "${WORKDIR}/fakeconnect-${PV}"

inherit autotools
