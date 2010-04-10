LICENSE = "GPL"
inherit gpe

DEPENDS = "libgpewidget"
SECTION = "gpe"

DESCRIPTION = "GPE task manager"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "fd52d952a11913f98c833f6af012099d"
SRC_URI[sha256sum] = "7d5938bea991f00e33268305ae11c977b92e4ab3392576f59132cd71fb7d782c"
