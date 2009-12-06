DESCRIPTION = "GKSu is a library that provides a Gtk+ frontend to su and sudo."
LICENSE = "GPLv2"
DEPENDS = "gtk+ libgksu nautilus"

SRC_URI = "http://people.debian.org/~kov/gksu/gksu-${PV}.tar.gz"

inherit autotools

PACKAGES =+ "${PN}-nautilus-extension"
FILES_${PN}-nautilus-extension = "${libdir}/nautilus/extensions-2.0/*.so"

