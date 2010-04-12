DESCRIPTION = "Volume Control Applet for GPE"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libgpewidget"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe autotools

SRC_URI += "file://setlocale.patch;patch=1"

SRC_URI[md5sum] = "087e60bbf0de3b8f14660977596bf6a1"
SRC_URI[sha256sum] = "6023a460561b02f9682213f10c4fcfd1dd848e94a3de99caf8cf9385bae8b093"
