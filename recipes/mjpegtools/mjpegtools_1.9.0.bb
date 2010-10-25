DESCRIPTION = "MJPEG video capture/editting/playback MPEG encoding"
HOMEPAGE = "http://sourceforge.net/projects/mjpeg/"
SECTION = "optional"
LICENSE = "GPLv2"
DEPENDS = "jpeg"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/mjpeg/${P}.tar.gz \
	file://mjpegtools-fix-include.patch \
	file://mjpegtools-remove-sdl-dependency.patch \
	file://mjpegtools-v4l-doesnt-mean-x11.patch \
	"

SRC_URI[md5sum] = "309a6fcf0900a010d6a9c1e91afc2f5c"
SRC_URI[sha256sum] = "a9322aaab1e0835fbaa00fc10e58e885833454fa0ad6f57c60c89a78f7ed1711"

inherit autotools

EXTRA_OECONF = "--without-x"
