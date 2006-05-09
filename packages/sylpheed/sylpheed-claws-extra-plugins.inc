SECTION = "x11/network"
DESCRIPTION = "Mail user agent plugins"
DEPENDS = "sylpheed-claws"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-claws/sylpheed-claws-extra-plugins-${PV}.tar.bz2"


inherit autotools pkgconfig

FILES_${PN} = "${libdir}/sylpheed-claws/plugins/*.so"

