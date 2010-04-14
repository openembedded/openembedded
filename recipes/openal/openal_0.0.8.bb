DESCRIPTION = "OpenAL is a cross-platform 3D audio API."
DEPENDS = "alsa-lib virtual/libsdl libvorbis"

SRC_URI = "http://www.openal.org/openal_webstf/downloads/${PN}-${PV}.tar.gz \
           file://void-workaround.patch"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-alsa --enable-sdl --enable-vorbis --disable-mp3 \
                --disable-smpeg --disable-arts"

do_configure_append () {
	sed -i "s/@requirements@/alsa vorbis/" admin/pkgconfig/openal.pc
}

do_stage () {
	autotools_stage_all
}

PACKAGES =+ "libopenal"

FILES_libopenal += "${libdir}/libopenal.so.*"
FILES_openal-dev += "${bindir}/openal-config"
FILES_openal = ""

SRC_URI[md5sum] = "641cf53761f35ee979f3e888614797a0"
SRC_URI[sha256sum] = "723e2c57c3cdffa7ff11f9b6b5478d6cb4af017e5a1ee7a56032969c39c1c2fe"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "0379bd39fc84454491ef38434a2e6e8d"
#SRC_URI[sha256sum] = "5eb6f111539d1a22030dc36f10ad20fed94148a66d71885265e8f1b931db4538"
