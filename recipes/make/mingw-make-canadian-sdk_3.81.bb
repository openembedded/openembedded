PR = "r0"

require make.inc

inherit canadian-sdk

DESCRIPTION = "GNU Make examines the timestamps on a set of \
interdependent files, and, if necessary, issues commands \
to bring them up-to-date - MinGW port."
HOMEPAGE = "http://www.mingw.org/"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/mingw32-make-3.81-20080326-src.tar.gz"

S = "${WORKDIR}/make-${PV}-patched"

SRC_URI[md5sum] = "7c21ed475aa72a0fd3115dcc12eaeaa2"
SRC_URI[sha256sum] = "f05c64eaa334cf6a59aacdfff3213fc53d0b670e79662fb25f029bfb78148bac"
