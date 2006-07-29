
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "apmd virtual/xserver xextensions virtual/libx11 libxau xscrnsaverh libxss"
SECTION = "x11/base"
RDEPENDS = "apm"

SRC_URI_append = " file://init-script-busybox.patch;patch=1"

PR = "r1"

DESCRIPTION = "Automatic sleep/suspend control daemon"

