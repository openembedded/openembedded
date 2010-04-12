LICENSE = "GPL"
inherit gpe

DEPENDS = "libgpewidget"
SECTION = "gpe"

DESCRIPTION = "GPE task manager"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "b82b56730f927335f20c6eaf20f509e0"
SRC_URI[sha256sum] = "406fe2dbc8cb6e8b56fa653f3d7b674203171233da097ee9ebb4413703f132ad"
