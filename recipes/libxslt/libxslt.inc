DESCRIPTION = "GNOME XSLT library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxml2 (>=2.6.27)"
LICENSE = "MIT"
INC_PR = "r4"

SRC_URI = "ftp://xmlsoft.org/libxml2/${BPN}-${PV}.tar.gz;name=archive"
S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"

EXTRA_OECONF = "--without-python --without-debug --without-mem-debug --without-crypto"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-utils ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dev += "${bindir}/xslt-config"
FILES_${PN}-utils += "${bindir}"
