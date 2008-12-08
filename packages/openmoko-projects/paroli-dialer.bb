DESCRIPTION = "Paroli-dialer, a plugin of Tichy"
HOMEPAGE = "http://code.google.com/p/paroli/"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS += "python-etk tichy"
RDEPENDS += "tichy python-evas python-etk python-edje python-ecore python-edbus"
PV = "0.1+svnr${SRCREV}"
PR = "r0"
S = "${WORKDIR}/paroli-dialer"

SRC_URI = "svn://paroli.googlecode.com/svn/trunk/packages/;module=paroli-dialer;proto=http"

inherit distutils
