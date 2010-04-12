DESCRIPTION = "Sugar base system"
LICENSE = "GPLv2"

PR = "r4"

DEPENDS = "sugar-toolkit libxml2 gtk+"
RDEPENDS = "sugar-toolkit sugar-base sugar-datastore gnome-python-desktop"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar/${PN}-${PV}.tar.bz2"

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


SRC_URI[md5sum] = "71af6b9632f441259e7ea5608db2ae5f"
SRC_URI[sha256sum] = "2172bfed8fdeab4279dad7712390fd98ae0a993c42c2c4eec98cf3d30d1a11aa"
