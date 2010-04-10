require apt.inc
PR = "r2"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

require apt-package.inc

apt-manpages += "doc/vendors.list.5 \
		 doc/fr/vendors.list.fr.5 \
		 doc/es/vendors.list.es.5 \
		 doc/de/apt.de.8"

SRC_URI[md5sum] = "26b37525371cdaaec552237e0667305d"
SRC_URI[sha256sum] = "57de084860870cccf510de62eb8ded252f5951a6e59e34a963d61d69de3aff10"
