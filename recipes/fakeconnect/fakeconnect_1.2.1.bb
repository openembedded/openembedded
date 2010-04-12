SECTION = "console/network"
DESCRIPTION = "FakeConnect is a application/network stress-test program."
LICENSE = "BSD"

SRC_URI = "http://www.hostname.org/fake_connect/fakeconnect-${PV}.tar.gz"
S = "${WORKDIR}/fakeconnect-${PV}"

inherit autotools

SRC_URI[md5sum] = "55220ebadef5f541d705b72fe222b5b1"
SRC_URI[sha256sum] = "4b891e1d58c8cdf397737ac81a9328d8c663743b41f835bb2267831866d75a3e"
