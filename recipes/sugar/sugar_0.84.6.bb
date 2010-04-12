DESCRIPTION = "Sugar base system"
LICENSE = "GPLv2"

DEPENDS = "sugar-toolkit libxml2 gtk+"
RDEPENDS = "sugar-toolkit sugar-base sugar-datastore sugar-artwork gnome-python gnome-python-desktop python-cjson python-pygtksourceview"

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


SRC_URI[md5sum] = "1747f7f35519b273e6c27bbcd8513d4b"
SRC_URI[sha256sum] = "f5db9c1caf5cd57abfccb12ab1f5ba508cbf0f90ec9bad03de3fb38063775b83"
