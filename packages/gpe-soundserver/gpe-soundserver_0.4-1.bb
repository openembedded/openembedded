LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DEPENDS = "libx11 esound-gpe"
RDEPENDS_${PN} = "esd"

SRC_URI += "file://makefile-breakage.patch;patch=1"
