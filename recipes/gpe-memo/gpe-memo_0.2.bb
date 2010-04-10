DESCRIPTION = "GPE Voice Notes Recorder"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget libgsm gpe-soundserver"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe autotools


SRC_URI[md5sum] = "3ec65b008347d4eb4fa0477787ebfc12"
SRC_URI[sha256sum] = "769faaf00a6da6b86e624407d636ec268593537a394fd99437aeb3e3f74c17eb"
