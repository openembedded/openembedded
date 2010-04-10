LICENSE = "GPL"
inherit gpe

DEPENDS = "libgpewidget"
SECTION = "gpe"

DESCRIPTION = "GPE task manager"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "dc5db99c16780086f76f48fc7d2e7ce5"
SRC_URI[sha256sum] = "d6c219bbcb01db0bce13da92bcba618206a057b6cf191dcac788e8b1d6e858a0"
