DESCRIPTION = "Command Line interface for Network Manager"
HOMEPAGE = "http://dev.openbossa.org/mamona/gitweb?p=users/salveti/netm-cli.git;a=summary"
LICENSE = "GPLv2"
SECTION = "console/network"
RDEPENDS = "python-dbus python-pygobject python-textutils networkmanager (>= 0.7)"
PR = "r3"
PV = "0.3+git"

inherit setuptools

SRC_URI = "git://dev.openbossa.org/mamona/users/salveti/netm-cli.git;protocol=http"

S = "${WORKDIR}/git"

FILES_${PN} += "${sysconfdir}/dbus-1/system.d/netm-cli.conf"
