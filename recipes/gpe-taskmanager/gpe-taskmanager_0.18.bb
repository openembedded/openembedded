LICENSE = "GPL"
inherit gpe

DEPENDS = "libgpewidget"
SECTION = "gpe"

DESCRIPTION = "GPE task manager"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"
