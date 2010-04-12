LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE to-do list"
DEPENDS = "gtk+ libdisplaymigration libgpewidget libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"
PR ="r1"

SRC_URI += "file://remove-render.patch;patch=1"


SRC_URI[md5sum] = "cc3b6b7676671b81251fb237118daada"
SRC_URI[sha256sum] = "ffaa97570c9d1a1f3c2081e208ec16a6b24e2700060b8cc3caad44ff447f16c7"
