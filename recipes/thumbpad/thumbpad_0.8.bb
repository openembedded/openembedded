DESCRIPTION = "Thumbpad is a tool to use a numeric keyboards for text input."
LICENSE = "GPL"

DEPENDS = "gtk+ libgpewidget virtual/libx11 libxtst"

SRC_URI = "http://projects.linuxtogo.org/frs/download.php/13/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/gpe"


SRC_URI[md5sum] = "384af26008a38cb64e50b87e3186d3ac"
SRC_URI[sha256sum] = "11b067df2ce38baa36566bd29ab14bbf2f7c0fcc15e01a5be2a6a85000c39104"
