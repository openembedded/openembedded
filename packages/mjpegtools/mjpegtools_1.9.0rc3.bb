DESCRIPTION = "Mjpeg tools is a suite of programs which support video capture, editting, playback, and compression to MPEG of MJPEG video."
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>
LICENSE = "GPL"
SECTION = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/mjpeg/mjpegtools-${PV}.tar.gz \
	file://mjpegtools-fix-include.patch;patch=1;pnum=1 \
	file://mjpegtools-remove-sdl-dependency.patch;patch=1;pnum=1 \
	file://mjpegtools-v4l-doesnt-mean-x11.patch;patch=1;pnum=1"

inherit autotools

EXTRA_OECONF = "--without-x"
