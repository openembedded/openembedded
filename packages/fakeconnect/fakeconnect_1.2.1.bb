SECTION = "console/network"
DESCRIPTION = "FakeConnect is a application/network stress-test program."
LICENSE = "BSD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "http://www.hostname.org/fake_connect/fakeconnect-${PV}.tar.gz"
S = "${WORKDIR}/fakeconnect-${PV}"

inherit autotools
