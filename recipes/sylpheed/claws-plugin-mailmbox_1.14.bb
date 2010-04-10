SECTION = "x11/network"
DESCRIPTION = "Mail user agent plugins"
DEPENDS = "claws-mail"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://www.claws-mail.org/downloads/plugins/mailmbox-${PV}.tar.gz\
           file://claws-plugin-mailmbox-fixup.patch;patch=1"

inherit autotools pkgconfig

S = "${WORKDIR}/mailmbox-${PV}"

FILES_${PN} = "${libdir}/claws-mail/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/claws-mail/plugins/.debug"

SRC_URI[md5sum] = "0a5907628c1112cf8e5fe251ed1db551"
SRC_URI[sha256sum] = "d8d948807b4a09eb6da392161564c4bcee01070c9c86483889f93f1b14fd0870"
