DESCRIPTION = "OpenAL is a cross-platform 3D audio API."
SRC_URI = "http://www.openal.org/openal_webstf/downloads/${PN}-${PV}.tar.gz"
DEPENDS = "alsa-lib virtual/libsdl libvorbis"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-alsa --enable-sdl --enable-vorbis --disable-mp3 \
                --disable-smpeg --disable-arts"

PACKAGES =+ "libopenal"
FILES_libopenal += "${libdir}/libopenal.so.*"
FILES_openal-dev += "${bindir}/openal-config"
FILES_openal = ""

do_configure_append () {
	sed -i "s/@requirements@/alsa vorbis/" admin/pkgconfig/openal.pc
}

do_stage () {
	autotools_stage_all
}
