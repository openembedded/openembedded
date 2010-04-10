DESCRIPTION = "Small ALSA library replacement for embedded system"
AUTHOR = "Takashi Iwai <tiwai@suse.de>"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
SRC_URI = "ftp://ftp.suse.com/pub/people/tiwai/salsa-lib/salsa-lib-${PV}.tar.bz2"

# as it overwrite alsa.pc only use if sure.
DEFAULT_PREFERRENCE = "-1"

inherit autotools pkgconfig


SRC_URI[md5sum] = "abfe905d58fbc0910434d08539e36ff6"
SRC_URI[sha256sum] = "8088a18b109f2c47eedd899f731b6f3fa9b92fa8b91335db0348802d28f8519e"
