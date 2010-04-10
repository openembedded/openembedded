# This recipe packages vlc as a library as well, so qt4 dependencies
# can be avoided when ony the library is installed.
# Would be cool if when newer vlc is added to OE and older ones are phased
# out that could be made the default.

require vlc.inc

# ffmpeg from git (library version => 52) is required
# libtool-native must be >= 2.2.4
DEPENDS += "libdvdcss libdvdread"

EXTRA_OECONF += "\
	--enable-dvdread \
"

LEAD_SONAME = "libvlc.so.2"

PACKAGES =+ "libvlc-dbg libvlc-dev libvlc"

FILES_libvlc-dev = "${libdir}/lib*.so"

FILES_libvlc-dbg = "\
	${libdir}/.debug \
	${libdir}/vlc/meta_engine/.debug \
	${libdir}/vlc/audio_filter/.debug ${libdir}/vlc/audio_output/.debug \
	${libdir}/vlc/demux/.debug ${libdir}/vlc/control/.debug \
	${libdir}/vlc/gui/.debug ${libdir}/vlc/packetizer/.debug \
	${libdir}/vlc/audio_mixer/.debug ${libdir}/vlc/stream_out/.debug \
	${libdir}/vlc/mux/.debug ${libdir}/vlc/access/.debug \
	${libdir}/vlc/visualization/.debug ${libdir}/vlc/access_filter/.debug \
	${libdir}/vlc/access_output/.debug ${libdir}/vlc/video_output/.debug \
	${libdir}/vlc/services_discovery/.debug ${libdir}/vlc/video_chroma/.debug \
	${libdir}/vlc/video_codec/.debug ${libdir}/vlc/video_filter/.debug \
	${libdir}/vlc/misc/.debug ${libdir}/vlc/codec/.debug \
	"

FILES_libvlc = "${libdir}/lib*.so.*"

FILES_${PN} += "${bindir}/vlc \
	${datadir}/applications \
	${datadir}/vlc/ \
	"

FILES_${PN}-dbg	+= "${libdir}/vlc/*/.debug"

SRC_URI[md5sum] = "69d4e30fe4fc2691780fbeacd40359d2"
SRC_URI[sha256sum] = "38b176fd495f3254db74e03977235a0a2212fc6533d7cd1a4c3dddc495b074f0"
