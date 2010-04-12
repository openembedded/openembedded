# This recipe packages vlc as a library as well, so qt4 dependencies
# can be avoided when ony the library is installed.
# Would be cool if when newer vlc is added to OE and older ones are phased
# out that could be made the default.

require vlc.inc

PR = "r3"

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

SRC_URI[md5sum] = "8ffa2ff763badd5de7592004d8d69a63"
SRC_URI[sha256sum] = "197c29803790efc0273bb4577d54629d0769a3b49b091c6430eb6704fd69824f"
