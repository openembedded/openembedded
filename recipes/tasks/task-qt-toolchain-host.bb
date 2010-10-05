require task-sdk-host.bb

DESCRIPTION = "Host packages for Qt SDK"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} += "qt4-tools-sdk"
RREPLACES_${PN} = "task-qte-toolchain-host"
