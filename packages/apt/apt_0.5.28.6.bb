include apt.inc
PR = "r1"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

include apt-package.inc

apt-manpages += "doc/vendors.list.5 \
		 doc/fr/vendors.list.fr.5 \
		 doc/es/vendors.list.es.5 \
		 doc/de/apt.de.8"
