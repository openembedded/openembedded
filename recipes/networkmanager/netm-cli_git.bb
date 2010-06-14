DESCRIPTION = "Command Line interface for Network Manager"
HOMEPAGE = "http://dev.openbossa.org/mamona/gitweb?p=users/salveti/netm-cli.git;a=summary"
LICENSE = "GPLv2"
SECTION = "console/network"
RDEPENDS_${PN} = "python-dbus python-pygobject python-textutils networkmanager (>= 0.7)"
PR = "r1"

SRCREV = "2c71e6b537c7fceb4bfe6e"

PV = "0.4+git"
PR_append = ".gitr${SRCREV}"

inherit setuptools

SRC_URI = "git://dev.openbossa.org/mamona/users/salveti/netm-cli.git;protocol=http"

S = "${WORKDIR}/git"

FILES_${PN} += "${sysconfdir}/dbus-1/system.d/netm-cli.conf"
