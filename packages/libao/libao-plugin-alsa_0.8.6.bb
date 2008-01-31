LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library. This is the ALSA plugin."
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "alsa-lib libao"
PROVIDES = "libao-alsa"
PACKAGES = "${PN}-dbg libao-alsa libao-alsa-dev"
PR = "r3"

SRC_URI = "http://downloads.xiph.org/releases/ao/libao-${PV}.tar.gz"
S = "${WORKDIR}/libao-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-esd --disable-esdtest \
		--disable-oss \
		--enable-alsa09 --enable-alsa09-mmap \
		--disable-arts --disable-nas"

do_stage() {
	install -d ${STAGING_LIBDIR}/ao
	install -d ${STAGING_LIBDIR}/ao/plugins-2
	oe_libinstall -so -C src/plugins/alsa09/.libs libalsa09 ${STAGING_LIBDIR}/ao/plugins-2
}

FILES_libao-alsa = "${libdir}/ao/plugins-2/libalsa*.so"
FILES_libao-alsa-dev = "${libdir}/ao/plugins-2/libalsa*.la"
