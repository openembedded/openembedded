LICENSE     = "GPL"
DESCRIPTION = "A GSM (De-)Multiplexer."
SECTION = "gsm"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "glibc"

inherit gpe

SRC_URI = "http://download2.berlios.de/gsmmux/${P}.tar.gz \
           file://gsmmux-makefile.patch;patch=1;pnum=0"
