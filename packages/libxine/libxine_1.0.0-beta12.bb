LICENSE = "GPL"
DESCRIPTION = "libxine is a library for multimedia players. \
It plays back CDs, DVDs, and VCDs. It also decodes multimedia \
files like AVI, MOV, WMV, and MP3 from local disk drives, \
and displays multimedia streamed over the Internet. It interprets \
many of the most common multimedia formats available - \
and some of the most uncommon formats, too."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libogg tremor libmad"
PR = "r4"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig binconfig gettext

SRC_URI = "${SOURCEFORGE_MIRROR}/xine/xine-lib-1-beta12.tar.gz \
	   file://full.patch;patch=1 \
	   file://libvorbis.patch;patch=1 \
	   file://demux_ogg.patch;patch=1 \
	   file://configure.ac.patch;patch=1 \
	   file://vo_scale.patch;patch=1 \
	   file://oss.patch;patch=1;pnum=0 \
	   file://fix-oss-plugin.patch;patch=1 \
	   file://mpegvideo-static-inlining.patch;patch=1 \
	   file://fix-syntax-xine-vorbis-decoder.patch;patch=1 \
	   file://fftscope-static-inlining.patch;patch=1"
S = "${WORKDIR}/xine-lib-1-beta12"

SOV = "1.0.6"

do_configure() {
	./autogen.sh --host ${TARGET_SYS} --build ${BUILD_SYS} \
	      --enable-shared --disable-static --prefix=${prefix} \
	      --with-zlib-path=${STAGING_DIR}/${HOST_SYS} --with-vorbis-prefix=${STAGING_DIR}/${HOST_SYS} \
	      --disable-oggtest --with-ogg-prefix=${STAGING_DIR}/${HOST_SYS} --without-x \
	--disable-iconv --without-arts --without-sdl \
	--disable-aalib
}

do_compile() {
	oe_runmake LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool OGG_LIBS=${STAGING_LIBDIR}/libogg.so
}

do_stage() {
	oe_runmake -e LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool \
	  -C src install-data \
	  'prefix=${STAGING_DIR}' 'exec_prefix=${STAGING_DIR}' \
	  'libdir=${STAGING_LIBDIR}' \
	  'includedir=${STAGING_INCDIR}'

	oe_runmake -e LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool \
	  -C include install-data \
	  'prefix=${STAGING_DIR}' 'exec_prefix=${STAGING_DIR}' \
	  'libdir=${STAGING_LIBDIR}' \
	  'includedir=${STAGING_INCDIR}'

	for plugin in `find ${S}/src -type f -name xineplug*.la`; do 
	  dir=`dirname $plugin`
	  libname=`basename $plugin|sed -e's,\.la,,'` 
	  oe_libinstall -so -C $dir $libname ${STAGING_LIBDIR}/xine/plugins/1.0.0
	done

	oe_libinstall -so -C src/xine-engine libxine ${STAGING_LIBDIR}
}

do_install() {
        oe_runmake -e LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool \
          -C src install-data \
          'prefix=${D}' 'exec_prefix=${D}' 'libdir=${D}${libdir}' \
          'includedir=${D}${includedir}' 

        oe_runmake -e LIBTOOL=${STAGING_BINDIR}/${TARGET_PREFIX}libtool \
          -C include install-data \
          'prefix=${D}' 'exec_prefix=${D}' 'libdir=${D}${libdir}' \
          'includedir=${D}${includedir}'

        for plugin in `find ${S}/src -type f -name xineplug*.la`; do
          dir=`dirname $plugin`
          libname=`basename $plugin|sed -e's,\.la,,'`
          oe_libinstall -so -C $dir $libname ${D}${libdir}/xine/plugins/1.0.0
        done

        oe_libinstall -so -C src/xine-engine libxine ${D}${libdir}
}

python populate_packages_prepend () {
	plugins_dir = bb.data.expand('${libdir}/xine/plugins/1.0.0/', d)
	
	do_split_packages(d, plugins_dir, file_regex='^xineplug_(.*).so$', output_pattern='libxine-plugin-%s', description='Xine plugin - %s')
}

