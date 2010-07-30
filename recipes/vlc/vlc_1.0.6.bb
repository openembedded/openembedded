# This recipe packages vlc as a library as well, so qt4 dependencies
# can be avoided when ony the library is installed.
# Would be cool if when newer vlc is added to OE and older ones are phased
# out that could be made the default.

require vlc.inc

SRC_URI[md5sum] = "246a3865ec037f8f5757ef6b973a80fc"
SRC_URI[sha256sum] = "f521933e7a1021746d8ecde6caa2f9d1b43187ab2e13df6abc07540e415e1842"

# ffmpeg from git (library version => 52) is required
# libtool-native must be >= 2.2.4
DEPENDS += "libdvdcss libdvdread"
PR = "r1"

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

