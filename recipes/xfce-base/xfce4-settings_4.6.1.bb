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
