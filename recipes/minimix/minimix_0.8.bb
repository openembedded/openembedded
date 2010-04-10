DESCRIPTION = "Volume Control Applet for GPE"
LICENSE = "GPL"
SECTION = "gpe"

DEPENDS = "libgpewidget"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpe autotools

SRC_URI[md5sum] = "0cfb89bf2596710543935e31ad1d5a17"
SRC_URI[sha256sum] = "aad022ce6fdefad1caf904bb66568e1f487b7b23301417a5a38faf826b418b5d"
