LICENSE = "GPL"
inherit gpe update-rc.d

DESCRIPTION = "GPE Display Manager"
SECTION = "gpe"
PRIORITY = "optional"
DEPENDS = "glib-2.0 xserver-common"
RDEPENDS_${PN} += "procps xserver-common"
PR = "r3"

INITSCRIPT_NAME = "gpe-dm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."


SRC_URI[md5sum] = "92e81fc34bb4643088efeaf1f6423483"
SRC_URI[sha256sum] = "4a78e69b44209d1c79a8649024584175aea518e5862d39c582944719a9a5e995"
