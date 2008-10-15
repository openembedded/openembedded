DESCRIPTION = "MediaTomb - UPnP AV MediaServer for Linux"
HOMEPAGE = "http://mediatomb.cc/"
LICENSE = "GPLv2"
DEPENDS = "expat ffmpeg sqlite3 libexif js zlib file id3lib"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/mediatomb/mediatomb-${PV}.tar.gz \
           file://curl.diff;patch=1 \
	   file://inotify.diff;patch=1 \
	  "

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-mysql \
                --disable-rpl-malloc \
		--enable-sqlite3 \
                --enable-libjs \
		--enable-libmagic \
		--enable-id3lib \
		--enable-libexif \
                --enable-db-autocreate \
		--disable-largefile \
                --with-sqlite3-h=${STAGING_INCDIR} \
                --with-sqlite3-libs=${STAGING_LIBDIR} \
                --with-magic-h=${STAGING_INCDIR} \
                --with-magic-libs=${STAGING_LIBDIR} \
                --with-exif-h=${STAGING_INCDIR} \
                --with-exif-libs=${STAGING_LIBDIR} \
                --with-zlib-h=${STAGING_INCDIR} \
                --with-zlib-libs=${STAGING_LIBDIR} \
                --with-js-h=${STAGING_INCDIR}/js \
                --with-js-libs=${STAGING_LIBDIR} \
                --with-id3lib-h=${STAGING_INCDIR} \
                --with-id3lib-libs=${STAGING_LIBDIR} \
		ac_cv_header_sys_inotify_h=yes"
