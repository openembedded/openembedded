LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library. This is the ALSA plugin."
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "alsa-lib libao"
PR = "r2"

SRC_URI = "http://downloads.xiph.org/releases/ao/libao-${PV}.tar.gz"
S = "${WORKDIR}/libao-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-esd --disable-esdtest \
		--disable-oss \
		--enable-alsa09 --enable-alsa09-mmap \
		--disable-arts --disable-nas"

do_stage() {
	oe_libinstall -so -C src libao ${STAGING_LIBDIR}
}

PACKAGES = "${PN}-dbg libao-alsa-plugin libao-alsa-plugin-dev"
FILES_libao-alsa-plugin= "${libdir}/ao/plugins-2/libalsa*.so"
FILES_libao-alsa-plugin-dev += "${libdir}/ao/plugins-2/libalsa*.la"
