DESCRIPTION = "Automatic sleep/suspend control daemon"
SECTION = "x11/base"
LICENSE = "GPL"
DEPENDS = "apmd virtual/xserver libxext virtual/libx11 libxau xscrnsaverh libxss"
DISTRO_APM ?= "apm"
RDEPENDS = "${DISTRO_APM}"
PR = "r7"

inherit gpe pkgconfig

SRC_URI_append = " file://init-script-busybox.patch;patch=1"
SRC_URI_append = " file://install-fix.patch;patch=1"
SRC_URI_append = " file://unbreak.patch;patch=1"

CONFFILES_${PN} += "${sysconfdir}/ipaq-sleep.conf"

SRC_URI[md5sum] = "6163ba21421d47d449991f88959a06cb"
SRC_URI[sha256sum] = "6e8c4f0ecc24c36436227ebb4cba2abbc0737be83103cb156f80ffa00aabbd8c"
