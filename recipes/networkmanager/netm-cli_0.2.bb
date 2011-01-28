DESCRIPTION = "Command Line interface for Network Manager"
HOMEPAGE = "http://dev.openbossa.org/mamona/gitweb?p=users/salveti/netm-cli.git;a=summary"
LICENSE = "GPLv2"
SECTION = "console/network"
RDEPENDS_${PN} = "python-dbus python-pygobject python-textutils networkmanager (>= 0.6) networkmanager (<= 0.7)"
PR = "r4"

inherit setuptools

SRC_URI = "git://dev.openbossa.org/mamona/users/salveti/netm-cli.git;protocol=http;tag=netm-cli-${PV}"
SRC_URI_append_mamona = " file://scan_support.patch"

S = "${WORKDIR}/git"
