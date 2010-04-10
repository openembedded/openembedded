DESCRIPTION = "Volume Control Applet for GPE"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libgpewidget"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe autotools

SRC_URI[md5sum] = "348ca2789f2a1ebc553ab187192f07bd"
SRC_URI[sha256sum] = "cdea38d41a67dac16243e068d25dfe1560519a065c9445055595b6397fa1ccd5"
