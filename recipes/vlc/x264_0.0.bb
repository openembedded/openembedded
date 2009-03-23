DESCRIPTION = "h264 encoder"
LICENSE = "GPL"

X264PV = "snapshot-20090127-2245"

SRC_URI = "http://download.videolan.org/pub/videolan/x264/snapshots/x264-${X264PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${X264PV}"

inherit autotools lib_package

EXTRA_OECONF = " --enable-shared "

do_stage() {
	autotools_stage_all
}




