DESCRIPTION = "GPE screenshot application"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r2"

RREPLACES_${PN} = "gpe-screenshot"

DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools

SRC_URI += " file://deviceinfo.patch;striplevel=0"

SRC_URI[md5sum] = "875ed73f43584cd3ece4a7ac28dd692a"
SRC_URI[sha256sum] = "a7ec60003a96975523598c2ef5f2927c9a362e689e7159b268c7fe431754635a"
