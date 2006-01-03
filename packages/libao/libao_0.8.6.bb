LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library"
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
PR = "r1"

SRC_URI = "http://downloads.xiph.org/releases/ao/libao-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-esd --disable-esdtest \
		--disable-alsa --disable-alsa09 \
		--disable-arts --disable-nas"

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/ao/plugins-2/*.so"
