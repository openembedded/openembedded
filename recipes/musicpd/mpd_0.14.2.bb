DESCRIPTION = "Music Player Daemon (mpd)"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libvorbis libogg libao zlib libmikmod flac audiofile virtual/libiconv faad2 pulseaudio curl lame \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag', d)}"

SRC_URI = "${SOURCEFORGE_MIRROR}/musicpd/mpd-${PV}.tar.bz2 \
	   file://mpd/mpd.conf \
           file://mpd/mpd.init"

PR = "r4"

inherit autotools update-rc.d
INITSCRIPT_NAME = "mpd"

# Setting --enable-mpd-{mad,id3tag} causes local caches of the libraries to
# be built, instead we use the OE built versions which should be installed
# in staging - remove the --with and replace with --enable to use the local
# versions.

EXTRA_OECONF = "\
		--enable-ogg \
		--with-id3tag-libraries=${STAGING_LIBDIR} \
		--with-id3tag-includes=${STAGING_INCDIR} \
		--with-mad-libraries=${STAGING_LIBDIR} \
		--with-mad-includes=${STAGING_INCDIR} \
        --with-faad-libraries=${STAGING_LIBDIR} \
		--with-faad-includes=${STAGING_INCDIR} \
        --disable-curl \
        --disable-ffmpeg \
        --disable-jack \
        --enable-pulse \
        --enable-mod \
        --disable-oggflac \
	--with-lame-includes=${STAGING_INCDIR}"

do_compile_prepend() {
    find -name Makefile | xargs sed -i 's~-I/usr/include~-I${STAGING_INCDIR}~g'
}

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/mpd/mpd.init ${D}${sysconfdir}/init.d/mpd
    install -m 644 ${WORKDIR}/mpd/mpd.conf ${D}${sysconfdir}/mpd.conf
}

