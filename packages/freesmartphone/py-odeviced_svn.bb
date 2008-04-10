DESCRIPTION = "The Open Device Daemon Prototype in Python"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python"
LICENSE = "GPLv2"
PV = "0.0+svnr${SRCREV}"
PR = "r0"

inherit distutils

#inherit update-rc.d
#INITSCRIPT_NAME = "py-odeviced"
#INITSCRIPT_PARAMS = "defaults 20"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=py-odeviced"
S = "${WORKDIR}/py-odeviced"

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
"
