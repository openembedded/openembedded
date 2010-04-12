DESCRIPTION="Xfce4 settings"
HOMEPAGE = "http://www.xfce.org"
SECTION = "x11/wm"
LICENSE = "GPL-2"

DEPENDS = "virtual/libx11 virtual/xserver libxi libwnck xrandr exo libxfce4util"
RDEPENDS = "gtk+ libxfce4util libxfcegui4 xfconf exo"

PR = "r1"

inherit xfce46

SRC_URI += " \
    file://xfce4-settings-4.6.1-libxklavier.patch;patch=1 \
    file://xfce4-settings-4.6.1-configure.patch;patch=1 \
"

do_stage() {
autotools_stage_all
}

SRC_URI[md5sum] = "dc1c8704471c5b0104fa10c30eb60cb6"
SRC_URI[sha256sum] = "36dda4d43366fad47ee95ea5d4fa336d0b14f79c524b4f29a2ac1b9ada4abf8d"
