LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DEPENDS = "diet-x11 esound-gpe"
RDEPENDS_${PN} = "esd"

SRC_URI += "file://makefile-breakage.patch;patch=1"
