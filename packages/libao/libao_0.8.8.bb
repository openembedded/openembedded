LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library"
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "alsa-lib pulseaudio"
PROVIDES = "libao-alsa libao-alsa-plugin"
PR = "r0"

SRC_URI = "http://downloads.xiph.org/releases/ao/libao-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-esd --disable-esdtest \
		--disable-alsa --enable-alsa09 \
		--disable-arts --disable-nas \
                --enable-pulse"

do_stage() {
	install -d ${STAGING_INCDIR}/ao
	install -m 0644 ${S}/include/ao/ao.h ${S}/include/ao/os_types.h \
			${S}/include/ao/plugin.h ${STAGING_INCDIR}/ao/

	oe_libinstall -so -C src libao ${STAGING_LIBDIR}
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ao.m4 ${STAGING_DATADIR}/aclocal/
}

PACKAGES =+ "${PN}-alsa ${PN}-alsa-dev ${PN}-pulse ${PN}-pulse-dev"

FILES_${PN}-alsa = "${libdir}/ao/plugins-2/libalsa*.so"
FILES_${PN}-alsa-dev = "${libdir}/ao/plugins-2/libalsa*.la"
FILES_${PN}-pulse = "${libdir}/ao/plugins-2/libpulse*.so"
FILES_${PN}-pulse-dev = "${libdir}/ao/plugins-2/libpulse*.la"

FILES_${PN} += "${libdir}/ao/plugins-2/*.so"
FILES_${PN}-dev += "${libdir}/ao/plugins-2/*.la"
FILES_${PN}-dbg += "${libdir}/ao/plugins-2/.debug"

