DESCRIPTION = "evopedia is an offline Wikipedia viewer "
AUTHOR = "Christian Reitwießner"
HOMEPAGE = "http://www.reitwiessner.de/openmoko/evopedia.html"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-xml python-shell python-netclient python-mime python-netserver \
             python-io kernel-module-squashfs"
RRECOMMENDS = "midori"
PV = "0.2.99+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://github.com/crei/evopedia.git;protocol=http;branch=master"

SRCREV = "51fd346f635d5715fdd3504ea4a4aa5453a1bfaa"
S = "${WORKDIR}/git/evopedia"

inherit distutils

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/applications \
                ${datadir}/evopedia \
                ${datadir}/pixmaps \
                "
