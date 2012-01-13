# Qt X11 toolchain
# mckoan - Marco Cavallini

require task-sdk-host.bb

DESCRIPTION = "Host packages for Qt X11 SDK"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} += "qt4-tools-sdk"
