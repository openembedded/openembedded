DESCRIPTION = "A GPE application that allows you to take screenshots."
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r0"

RREPLACES = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

SRC_URI[md5sum] = "eaf545561b0ad981c9d01833f30fcf95"
SRC_URI[sha256sum] = "762778421fae7c62d5ec6a9d27986166c0dbbe2ff51fc10bb9b8baff5c367534"
