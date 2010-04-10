DESCRIPTION = "Music Player Daemon (mpd). This version is configured for alsa support"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libvorbis libogg libao-alsa zlib flac audiofile virtual/libiconv faad2 \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag', d)}"
RDEPENDS = "libao-alsa"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpd-${PV}.tar.bz2 \
file://mpd/mpd.conf \
file://mpd/mpd.init"

PR = "r3"

S = "${WORKDIR}/mpd-${PV}"
inherit autotools update-rc.d
INITSCRIPT_NAME = "mpd"

# Setting --enable-mpd-{mad,id3tag} causes local caches of the libraries to
# be built, instead we use the OE built versions which should be installed
# in staging - remove the --with and replace with --enable to use the local
# versions.

EXTRA_OECONF = "\
--enable-ogg \
--enable-oggvorbis \
--disable-oggflac \
--enable-flac \
--enable-faad \
--with-ao-libraries=${STAGING_LIBDIR} \
--with-ao-includes=${STAGING_INCDIR} \
--with-iconv-libraries=${STAGING_LIBDIR} \
--with-iconv-includes=${STAGING_INCDIR} \
--with-id3tag-libraries=${STAGING_LIBDIR} \
--with-id3tag-includes=${STAGING_INCDIR} \
--with-faad-libraries=${STAGING_LIBDIR} \
--with-faad-includes=${STAGING_INCDIR} \
--with-mad-libraries=${STAGING_LIBDIR} \
--with-mad-includes=${STAGING_INCDIR} \
--with-ogg-libraries=${STAGING_LIBDIR} \
--with-ogg-includes=${STAGING_INCDIR} \
--with-vorbis-libraries=${STAGING_LIBDIR} \
--with-vorbis-includes=${STAGING_INCDIR} \
--disable-aotest \
--disable-alsatest \
--disable-oggtest \
--disable-vorbistest \
--disable-libFLACtest \
--disable-libOggFLACtest  \
--disable-audiofiletest  \
--disable-libmikmodtest \
--with-lame-includes=${STAGING_INCDIR} \
"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd/mpd.init ${D}${sysconfdir}/init.d/mpd
	install -m 644 ${WORKDIR}/mpd/mpd.conf ${D}${sysconfdir}/mpd.conf
}

SRC_URI[md5sum] = "66817a4b4c05454e6488f6b821f2a6a3"
SRC_URI[sha256sum] = "0b3926a141873f179efc3c3b9d296b65d332dbb898340ac5e5d1dd0c3dd9fb20"
