DESCRIPTION = "Sugar base system"
LICENSE = "GPLv2"

DEPENDS = "sugar-toolkit libxml2 gtk+"
RDEPENDS = "sugar-toolkit sugar-base sugar-datastore gnome-python-desktop"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base mime

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime/packages \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${sysconfdir} "

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


SRC_URI[md5sum] = "6b981c63bb5d8b23b43831ece79884e6"
SRC_URI[sha256sum] = "254ac13ceeba17749ff6416b33fd038f8db7aaf6fab2e0a9d2303dd07314b186"
