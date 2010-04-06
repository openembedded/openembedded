DESCRIPTION = "programs for mounting, unmounting and ejecting storage devices"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "nautilus gnome-keyring libglade libnotify"

inherit autotools gnome pkgconfig

SRCREV = "150a8d10d9336dea107ed3b5ddd430f6dcd5bd83"
PV = "0.8"

SRC_URI = "http://hal.freedesktop.org/releases/gnome-mount-${PV}.tar.gz"

SRC_URI[archive.md5sum] = "562ec9d0196e5e000bdd249a04a3aa6a"
SRC_URI[archive.sha256sum] = "44ca6b78b49a4181435e489c7b7d416c8f26442dcecdc01ec4b981274ed957e2"

S = "${WORKDIR}/gnome-mount-${PV}"

FILES_${PN} += "${libdir}/nautilus"
FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"


