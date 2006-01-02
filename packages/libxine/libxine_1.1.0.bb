DESCRIPTION = "libxine is a versatile multimedia library decoding a lot of common audio and video formats. \
This version is configued for the usage with X11"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "zlib libogg libvorbis tremor libmad libmodplug esound-gpe x11 xext"
PROVIDES = "virtual/libxine"
PR = "r0"

inherit autotools pkgconfig gettext binconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/xine/xine-lib-${PV}.tar.gz \
    file://configure.patch;patch=1 \
    file://cpuid.patch;patch=1 \
    file://fix-syntax-xine-vorbis-decoder.patch;patch=1 \
    file://libxine-arm-configure.patch;patch=1 \
    file://libxine-cut-memusage.patch;patch=1 \
    file://libxine-ffmpeg-enable-arm.patch;patch=1 \
#    file://libxine-libavcodec.patch;patch=1 \
    file://tremor.patch;patch=1 \
    file://libxine-tremor-autoconf.patch;patch=1 \
    file://mpegvideo-static-inlinine.patch;patch=1 \
    file://no-caca.patch;patch=1 \
    file://dont-have-xv.patch;patch=1 \
"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/xine-lib-${PV}"

SOV = "1.0.7"

EXTRA_OECONF="-with-zlib-path=${STAGING_DIR}/${HOST_SYS} \
	--with-vorbis-prefix=${STAGING_DIR}/${HOST_SYS} \
	--disable-oggtest \
	--with-ogg-prefix=${STAGING_DIR}/${HOST_SYS} \
	--disable-altivec --disable-vis --disable-mlib \
	--disable-fb --disable-alsa --disable-vcd \
	--disable-asf --disable-faad --disable-iconv \
	--without-v4l --without-arts --without-sdl \
	--without-xv  --without-xxmc --without-xvmc \
	--with-x --x-includes=${STAGING_INCDIR}/X11 --x-libraries=${STAGING_LIBDIR}"

do_compile() {
	oe_runmake LIBTOOL=${S}/${TARGET_SYS}-libtool
}

do_install() {
	oe_runmake DESTDIR=${D} LIBTOOL=${S}/${TARGET_SYS}-libtool install
}

HEADERS="src/xine-engine/xineintl.h src/xine-utils/xineutils.h            \
	src/xine-engine/xine_internal.h  src/xine-engine/xine_plugin.h    \
	src/xine-utils/xine_buffer.h     src/xine-engine/video_out.h      \
	src/xine-engine/buffer.h         src/xine-engine/vo_scale.h       \
	src/xine-engine/configfile.h     src/xine-utils/attributes.h      \
	src/xine-engine/info_helper.h    src/xine-engine/scratch.h        \
	src/xine-engine/audio_decoder.h  src/input/input_plugin.h         \
	src/xine-engine/spu_decoder.h    src/xine-engine/audio_out.h      \
	src/xine-engine/io_helper.h      src/xine-engine/video_decoder.h  \
	src/xine-engine/broadcaster.h    src/xine-engine/metronom.h       \
	src/xine-utils/xmllexer.h        src/xine-engine/osd.h            \
	src/xine-engine/video_overlay.h  src/xine-utils/xmlparser.h       \
	src/xine-utils/compat.h          src/xine-engine/plugin_catalog.h \
	src/xine-engine/post.h           src/demuxers/demux.h             \
	src/xine-engine/resample.h	 lib/os_types.h                   \
	src/xine-engine/refcounter.h"

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

	plugindir = bb.data.expand('${libdir}/xine/plugins/1.1.0', d)
	do_split_packages(d, plugindir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

	postdir = bb.data.expand('${libdir}/xine/plugins/1.1.0/post', d)
	do_split_packages(d, postdir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

	fontdir = bb.data.expand('${datadir}/xine/libxine1/fonts', d)
	do_split_packages(d, fontdir, '^(.*).xinefont.gz$', 'libxine-font-%s', 'Xine font %s', extra_depends='' )
}

# Omit the annoying xine-config in ${bindir}
FILES_${PN}="${libdir}/*.so*"

# And include it in the dev package
FILES_${PN}-dev += " ${bindir}"
