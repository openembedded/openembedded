DESCRIPTION = "Sugar etoys"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar"
RDEPENDS = "sugar shared-mime-info"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/etoys/etoys-${PV}.tar.gz \
           file://etoys.diff;patch=1"

inherit autotools distutils-base

do_configure_prepend() {
        mkdir -p ${S}/m4
}

PACKAGES_ARCH = "all"
FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/xsessions \
                ${datadir}/dbus-1 \
                ${datadir}/sugar/activities \
                ${sysconfdir} "


SRC_URI[md5sum] = "3eeb43af8c6bc0a30b46739707e27259"
SRC_URI[sha256sum] = "8b5499c26860c8a11750e9e03b9a7d70dd8e7ffce16457e9ee9d7850d554e7ab"
