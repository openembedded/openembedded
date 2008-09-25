DESCRIPTION = "Stalonetray is a stand-alone freedesktop.org and KDE system tray"
LICENSE = "GPLv2"
DEPENDS = "virtual/libx11"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools

