DESCRIPTION = "Tea - a GTK based text editor with highlighting and a lot of processing features"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "gtk+ gtksourceview1"
PR = "r2"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/tea-editor/${P}.tar.bz2 \
           file://move-endif.patch;patch=1;pnum=0"

EXTRA_OECONF = "--enable-legacy"

SRC_URI[md5sum] = "c28db354576aaec2152970b06d534640"
SRC_URI[sha256sum] = "a7147079740acef2df0d2caab164062b12806d988216aa03667198d1100f5eb2"
