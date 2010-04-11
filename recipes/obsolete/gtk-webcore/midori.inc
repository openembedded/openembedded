DESCRIPTION = "Midori is a lightweight web browser."
LICENSE = "GPLv2"

DEPENDS = "webkit-gtk libsoup-2.4 libsexy" 

PE = "1"

inherit autotools gtk-icon-cache pkgconfig

SRC_URI = "http://software.twotoasts.de/media/midori/midori-${PV}.tar.gz"

EXTRA_OECONF = "  --disable-hildon "

TARGET_CC_ARCH += "${LDFLAGS}"
