LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library. This is the ALSA plugin."
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Matthias Goebl <matthias.goebl@goebl.net>"
DEPENDS = "alsa-lib libao"
RDEPENDS = "libao2 (>=${PV})"
PR = "r1"

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

PACKAGES = "libao-alsa-plugin libao-alsa-plugin-dev"
FILES_libao-alsa-plugin= "${libdir}/ao/plugins-2/libalsa*.so"
FILES_libao-alsa-plugin-dev += "${libdir}/ao/plugins-2/libalsa*.la"
