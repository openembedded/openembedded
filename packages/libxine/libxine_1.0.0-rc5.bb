LICENSE = "GPL"
DESCRIPTION = "libxine"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Pawel Osiczko <p.osiczko@tetrapyloctomy.org>"
DEPENDS = "zlib libogg tremor libmad esound-gpe"
PROVIDES = "virtual/libxine"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig gettext

S = "${WORKDIR}/xine-lib-1-rc5"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/xine/xine-lib-1-rc5.tar.gz \
	file://cpu.patch;patch=1 \
	file://configure.patch;patch=1 \
	file://no-caca-no-aalib.patch;patch=1 \
	file://libxine-tremor-autoconf.patch;patch=1 \
	file://libxine-libvorbis.patch;patch=1"

SOV = "1.0.6"

# Omit the annoying xine-config in ${bindir}
FILES_${PN}="${libdir}/*.so*"

# And include it in the dev package
FILES_${PN}-dev += " ${bindir}"

EXTRA_OECONF="-with-zlib-path=${STAGING_DIR}/${HOST_SYS} \
	--with-vorbis-prefix=${STAGING_DIR}/${HOST_SYS} \
	--disable-oggtest \
	--with-ogg-prefix=${STAGING_DIR}/${HOST_SYS} \
	--disable-altivec --disable-vis --disable-mlib \
	--disable-fb --disable-alsa --disable-vcd \
	--disable-asf --disable-faad --disable-iconv \
	--without-v4l --without-arts --without-sdl"
			      
do_compile() {
	oe_runmake LIBTOOL=${S}/${TARGET_SYS}-libtool
}

do_install() {
	oe_runmake DESTDIR=${D} LIBTOOL=${S}/${TARGET_SYS}-libtool install
}

HEADERS="src/xine-engine/xineintl.h src/xine-utils/xineutils.h \
	src/xine-engine/xine_internal.h src/xine-engine/xine_plugin.h \
	src/xine-utils/xine_buffer.h"

do_stage() {
	install -d ${STAGING_INCDIR}/xine

	install -m 0644 ${S}/include/xine.h ${STAGING_INCDIR}

	for file in ${HEADERS}; do
		cp ${S}/$file ${STAGING_INCDIR}/xine/`basename $file`
	done

	install -m 0644 ${S}/m4/xine.m4 ${STAGING_DATADIR}/aclocal/

	oe_libinstall -so -C src/xine-engine libxine ${STAGING_LIBDIR}
}

python populate_packages_prepend () {
	bb.data.setVar('PKG_libxine', 'libxine', d)

	plugindir = bb.data.expand('${libdir}/xine/plugins/1.0.0', d)
	do_split_packages(d, plugindir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s')

	postdir = bb.data.expand('${libdir}/xine/plugins/1.0.0/post', d)
	do_split_packages(d, postdir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s')

	fontdir = bb.data.expand('${datadir}/xine/libxine1/fonts', d)
	do_split_packages(d, fontdir, '^(.*).xinefont.gz$', 'libxine-font-%s', 'Xine font %s')
}
