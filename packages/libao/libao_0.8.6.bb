LICENSE = "GPL"
DESCRIPTION = "A cross platform audio library"
HOMEPAGE = "http://www.xiph.org/ao/"
SECTION = "libs"
PRIORITY = "optional"
PR = "r0"

SRC_URI = "http://www.xiph.org/ao/src/libao-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-esd --disable-esdtest \
		--disable-alsa --disable-alsa09 \
		--disable-arts --disable-nas"

do_stage() {
	install -d ${STAGING_INCDIR}/ao
	install -m 0644 ${S}/include/ao/ao.h ${S}/include/ao/os_types.h \
			${S}/include/ao/plugin.h ${STAGING_INCDIR}/ao/

	oe_libinstall -so -C src libao ${STAGING_LIBDIR}
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ao.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN} += "${libdir}/ao/plugins-2/*.so"
