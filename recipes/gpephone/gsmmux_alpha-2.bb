LICENSE     = "GPL"
DESCRIPTION = "A GSM (De-)Multiplexer."
SECTION = "gsm"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "glibc"

inherit gpe

SRC_URI = "http://download2.berlios.de/gsmmux/${P}.tar.gz \
           file://gsmmux-makefile.patch;patch=1;pnum=0"

SRC_URI[md5sum] = "5bfa5605d9565ff01138d7a574cc2614"
SRC_URI[sha256sum] = "fc029984019736eab2b0f10ce28d48ff88f8ceed7a1739cb4b71b851c4b89b91"
