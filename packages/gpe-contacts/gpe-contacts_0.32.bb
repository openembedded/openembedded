LICENSE = "GPL"
inherit gpe

PR = "r0"

DEPENDS = "libgpewidget libgpepimc libdisplaymigration libgpevtype libxml2 dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE contacts manager"

FILES_${PN} += " ${datadir}/gpe ${datadir}/gpe-contacts"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
		   file://new-button-disabled-after-window-close.patch;patch=1;pnum=0 \
                   file://filtered-paste.patch;patch=1;pnum=0 \
                   file://select-start.patch;patch=1;pnum=0"
