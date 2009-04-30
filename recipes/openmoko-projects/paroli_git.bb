DESCRIPTION = "Paroli"
SECTION = "x11"
LICENSE = "GPL"
PV = "0.2+gitr${SRCPV}"
PR = "r0"
PE = "1"

SRC_URI = "git://git.paroli-project.org/paroli.git;protocol=http"
S = "${WORKDIR}/git"

inherit distutils

RDEPENDS = "\
  python-datetime \
  python-subprocess \
  python-textutils \
  python-dbus \
  python-pygobject \
"

FILES_${PN} += "${sysconfdir}/dbus-1 ${sysconfdir}/paroli ${datadir}"
