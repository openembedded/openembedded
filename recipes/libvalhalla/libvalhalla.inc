DESCRIPTION = "libvalhalla is a library written in C. It is a media scanner, that stores various information in an SQLite database and relies on FFmpeg (libavformat and libavutil) and libcurl. It features many Internet grabbers that allows automatic download of covers, lyrics, informations on media files, tags retrival in video and music files and so on."
HOMEPAGE = "http://libvalhalla.geexbox.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1"
DEPENDS = "sqlite3 curl ffmpeg libnfo"

INC_PR = "r0"

SRC_URI = "http://libvalhalla.geexbox.org/releases/${P}.tar.bz2;name=${PN}"

inherit autotools pkgconfig

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure() {
	${S}/configure \
			--prefix=${prefix} \
			--disable-strip \
		--with-lavf-inc=${STAGING_INCDIR} \
		--with-lavf-lib=${STAGING_LIBDIR} \
		--with-lavc-inc=${STAGING_INCDIR} \
		--with-lavc-lib=${STAGING_LIBDIR} \
		--cross-compile \
		--enable-pic \
                --enable-doc
}

PACKAGES =+ "${PN}-bin"

FILES_${PN}-bin = "${bindir}/*"
