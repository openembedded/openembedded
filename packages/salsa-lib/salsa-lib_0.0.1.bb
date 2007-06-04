DESCRIPTION = "Small ALSA library replacement for embedded system"
AUTHOR = "Takashi Iwai <tiwai@suse.de>"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
SRC_URI = "ftp://ftp.suse.com/pub/people/tiwai/salsa-lib/salsa-lib-${PV}.tar.bz2"

# as it overwrite alsa.pc only use if sure.
DEFAULT_PREFERRENCE = "-1"

inherit autotools pkgconfig

