
LICENSE = "GPL"
PR = "r3"

inherit gpe pkgconfig

DEPENDS = "apmd virtual/xserver xextensions libx11 libxau xscrnsaverh libxss"
SECTION = "x11/base"
RDEPENDS = "apm"

DESCRIPTION = "Automatic sleep/suspend control daemon"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

#CPPFLAGS_append += " -DDEBUG"
#CFLAGS_append += " -DDEBUG"
