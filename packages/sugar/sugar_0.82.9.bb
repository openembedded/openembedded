DESCRIPTION = "Sugar base system"
LICENSE = "GPLv2"

PR = "r3"

DEPENDS = "sugar-toolkit libxml2 gtk+"
RDEPENDS = "sugar-toolkit sugar-base sugar-datastore gnome-python-desktop"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base

do_configure_prepend() {
	mkdir -p ${S}/m4
}	

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/mime \
		${datadir}/xsessions \
		${datadir}/dbus-1 \
		${sysconfdir} "

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

