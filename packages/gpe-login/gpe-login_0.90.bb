DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd gpe-theme-clearlooks"
RPROVIDES = "gpe-session-starter"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig


SRC_URI += "file://removeblue-fontsize8.patch;patch=1"
SRC_URI += " file://chvt-keylaunch.patch;patch=1 "

SRC_URI_append_spitz = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_akita = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_c7x0 = "file://brightness-adjust-keyluanchrc.patch;patch=1"

