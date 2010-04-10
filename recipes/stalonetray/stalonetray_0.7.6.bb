DESCRIPTION = "Stalonetray is a stand-alone freedesktop.org and KDE system tray"
LICENSE = "GPLv2"
DEPENDS = "virtual/libx11"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2"

inherit autotools


SRC_URI[md5sum] = "eebb46182b64d75b89776bbfc867f470"
SRC_URI[sha256sum] = "35043df77437b66ade4a07b69f31aaa8c157ddc2833899eeb8a4794399a9e061"
