SECTION = "x11/network"
DESCRIPTION = "Mail user agent plugins"
DEPENDS = "claws-mail libxml2 curl glib-2.0 gtk+"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.claws-mail.org/downloads/plugins/rssyl-${PV}.tar.gz"

inherit autotools pkgconfig

S = "${WORKDIR}/rssyl-${PV}"

FILES_${PN} = "${libdir}/claws-mail/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/claws-mail/plugins/.debug"

SRC_URI[md5sum] = "7dfd8ae53cf1ed88d5e4150f77b9df63"
SRC_URI[sha256sum] = "b02eff373fd66daec2ffd75afd3ad97c32c45679883ee65b21aa50fec92fc752"
