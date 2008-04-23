DESCRIPTION = "eSpeak is a compact open source software speech synthesizer"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/espeak/espeak-${PV}-source.zip"

S = "${WORKDIR}/espeak-${PV}-source"

DEPENDS = "portaudio-v19"
