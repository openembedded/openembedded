DESCRIPTION = "python-elementary and python-blipapi based blip.pl client"
AUTHOR = "Sebastian Krzyszkowiak <seba.dos1@gmail.com>"
HOMEPAGE = "http://wiki.github.com/dos1/blipomoko"
LICENSE ?= "GPL"
RDEPENDS_${PN} = "python-elementary python-dbus python-edbus python-ecore"
SECTION = "x11/applications"

SRC_URI = "git://github.com/dos1/blipomoko.git;protocol=http"
S = "${WORKDIR}/git"

SRCREV = "73ffa20d535d7bcf693981ac00d488db72dd2f68"
PV = "0.2.99+gitr${SRCPV}"
PR = "r0"

inherit distutils

FILES_${PN} += "/usr/share/blipomoko"

