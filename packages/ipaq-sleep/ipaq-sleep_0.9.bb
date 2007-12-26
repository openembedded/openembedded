
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "apmd virtual/xserver libxext virtual/libx11 libxau xscrnsaverh libxss"
SECTION = "x11/base"
RDEPENDS = "apm"

SRC_URI_append = " file://init-script-busybox.patch;patch=1"
SRC_URI_append = " file://install-fix.patch;patch=1"
SRC_URI_append = " file://unbreak.patch;patch=1"

PR = "r5"

DESCRIPTION = "Automatic sleep/suspend control daemon"

CONFFILES_${PN} += "${sysconfdir}/ipaq-sleep.conf"
