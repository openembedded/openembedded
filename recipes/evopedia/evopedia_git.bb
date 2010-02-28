DESCRIPTION = "evopedia is an offline Wikipedia viewer "
AUTHOR = "Christian Reitwießner"
HOMEPAGE = "http://www.reitwiessner.de/openmoko/evopedia.html"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-xml python-shell python-netclient python-mime \
            python-netserver python-io python-compression"
RRECOMMENDS = "midori"
PV = "0.3.0-rc3+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://github.com/crei/evopedia.git;protocol=http;branch=master"

SRCREV = "2e92cc7b4b709c7551337e7a2c76e6737c241e38"
S = "${WORKDIR}/git/evopedia"

inherit distutils

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/applications \
                ${datadir}/evopedia \
                ${datadir}/pixmaps \
                "
