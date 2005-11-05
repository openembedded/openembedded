DESCRIPTION = "RtAudio is a set of C++ classes which provide a common API \
for realtime audio input/output across Linux (native ALSA, JACK, and OSS), \
Macintosh OS X, SGI, and Windows (DirectSound and ASIO) operating systems."
SECTION = "libs"
LICENSE = "rtaudio"
HOMEPAGE = "http://www.music.mcgill.ca/~gary/rtaudio"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "alsa-lib"
PR = "r0"

SRC_URI = "http://music.mcgill.ca/~gary/rtaudio/release/rtaudio-${PV}.tar.gz"
S = "${WORKDIR}/rtaudio-${PV}"

inherit qmake qt3x11

do_configure_prepend() {
	qmake -project -t lib -nopwd *.cpp *.h
}

EXTRA_QMAKEVARS_POST = "CONFIG=console CONFIG+=thread DEFINES+=__LINUX_OSS__ DEFINES+=__LINUX_ALSA__ LIBS+=-lasound"

do_stage() {
	install -m 0644 *.h ${STAGING_INCDIR}
	oe_libinstall -so librtaudio-3.0.1 ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so librtaudio-3.0.1 ${D}${libdir}
}
