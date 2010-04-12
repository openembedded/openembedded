inherit gpe autotools

PR = "r0"
DESCRIPTION = "GPE wireless LAN communication applet"
DEPENDS  = "gtk+ libgpewidget prismstumbler"
RDEPENDS = "prismstumbler"
SECTION  = "gpe"
PRIORITY = "optional"
LICENSE  = "GPL"

GPE_TARBALL_SUFFIX = "bz2"

SRC_URI[md5sum] = "b0d4967f8d0af9d2c647ce6cfa2c7ab9"
SRC_URI[sha256sum] = "c22a17a07acfa8f2f7243afe6e00005e09a4ebe8adeb78dbe83c06ccbfa7ec0f"
