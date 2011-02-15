DESCRIPTION = "Simple DirectMedia Layer mixer library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl flac libmikmod libvorbis  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"
LICENSE = "LGPL"

PR = "r7"

SRC_URI = "http://www.libsdl.org/projects/SDL_mixer/release/SDL_mixer-${PV}.tar.gz \
           file://fix-flac-madness.diff \
           file://configure.patch \
          "

S = "${WORKDIR}/SDL_mixer-${PV}"

inherit autotools

# Although we build SMPEG lets not use it as it is pointless in the embedded space.

# Add support for runtime linking with libmad so we can use that for fixed point MP3 decoding.
# Add support for runtime linking with libtremor so we can use that for fixed point OGG Vorbis decoding.

EXTRA_AUTORECONF += "--include=acinclude"

do_configure_prepend () {
        # Remove old libtool macros.
        MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
        for i in ${MACROS}; do
               rm -f acinclude/$i
        done
        cp build-scripts/* .
        rm -rf build-scripts/
        export SYSROOT=$PKG_CONFIG_SYSROOT_DIR
}

EXTRA_OECONF = "--disable-music-mp3 --enable-music-ogg --enable-music-ogg-tremor ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-music-mp3-mad-gpl', d)} LIBS=-L${STAGING_LIBDIR}"

SRC_URI[md5sum] = "65ada3d997fe85109191a5fb083f248c"
SRC_URI[sha256sum] = "86145ac39cac6d2c6169c226f937648dca5e89dcd828751763dd174fa9af9cf9"
