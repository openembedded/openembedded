DESCRIPTION = "Thumbpad is a tool to use a numeric keyboards for text input."
LICENSE = "GPL"

DEPENDS = "gtk+ libgpewidget virtual/libx11 libxtst"

SRC_URI = "http://projects.linuxtogo.org/frs/download.php/13/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/gpe"

