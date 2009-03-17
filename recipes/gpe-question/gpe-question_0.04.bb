LICENSE = "GPL"
inherit gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

DEPENDS = "libgpewidget"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
DESCRIPTION = "GPE interface for asking questions from shell scripts"
