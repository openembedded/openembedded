PR = "r0"

require make.inc

inherit canadian-sdk

DESCRIPTION = "GNU Make examines the timestamps on a set of \
interdependent files, and, if necessary, issues commands \
to bring them up-to-date - MinGW port."
HOMEPAGE = "http://www.mingw.org/"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/mingw32-make-3.81-20080326-src.tar.gz"

S = "${WORKDIR}/make-${PV}-patched"
