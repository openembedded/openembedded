DESCRIPTION = "Zile is a very small emacs-like editor."
HOMEPAGE = "http://zile.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "ncurses"
PRIORITY = "optional"
SECTION = "console/editors"
PR = "r1"

UV = "${@bb.data.getVar('PV', d, 1).split('+')[1]}"

SRC_URI = "${SOURCEFORGE_MIRROR}/zile/zile-${UV}.tar.gz \
	   file://for_build.patch;patch=1"
S = "${WORKDIR}/zile-${UV}"

inherit autotools

export CC_FOR_BUILD = "${BUILD_CC}"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS} -DHAVE_VASPRINTF"
export LDFLAGS_FOR_BUILD = "${BUILD_LDFLAGS}"

SRC_URI[md5sum] = "538e86a10a0c373f98a4c2dff29b39dd"
SRC_URI[sha256sum] = "84568814469d4d7c44a324badb8023b049aae5d5f17e4b788a955f8d5137b3c4"
