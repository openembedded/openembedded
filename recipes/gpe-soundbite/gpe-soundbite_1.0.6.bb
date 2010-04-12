LICENSE = "GPL"
inherit gpe pkgconfig

SRC_URI += "file://makefile-fix.patch;patch=1"

DESCRIPTION = "GPE audio Recorder"
DEPENDS = "gtk+ libgpewidget libglade libgsm gpe-soundserver"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LDFLAGS_append = " -Wl,--export-dynamic"

SRC_URI[md5sum] = "9eac057d9a91b5b12b2b1cd7d88b60a6"
SRC_URI[sha256sum] = "44278e12358531f588501b2d79bb3a32c69e3cddb243674a414df20e3990f196"
