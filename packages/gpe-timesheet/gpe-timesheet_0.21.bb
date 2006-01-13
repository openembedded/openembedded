LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE time tracker"
DEPENDS = "libgpewidget gtk+ sqlite"
SECTION = "gpe"
RDEPENDS = "gpe-icons"

SRC_URI = "${GPE_MIRROR}/gpe-timesheet-${PV}.tar.gz"
