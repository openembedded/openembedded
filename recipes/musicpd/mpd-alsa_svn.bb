DESCRIPTION = "Music Player Daemon (mpd). This version is configured for alsa support"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "libvorbis libogg libao-alsa zlib flac audiofile virtual/libiconv faad2 \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad libid3tag', d)}"
RDEPENDS = "libao-alsa"
PV = "0.11.5+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://svn.musicpd.org/mpd;module=trunk;proto=https \
		file://mpd/mpd.init"
#           file://mpd/save-volume-state.patch;patch=1 \

S = "${WORKDIR}/trunk"

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
"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/mpd/mpd.init ${D}${sysconfdir}/init.d/mpd
}
