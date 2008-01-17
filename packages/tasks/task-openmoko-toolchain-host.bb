require task-sdk-host.bb

DESCRIPTION = "Packages for a standalone OpenMoko SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r0"

PACKAGES = "${PN}"

RDEPENDS_${PN} += "\
    openmoko-sample2-src \
"
require task-sdk-host.bb

DESCRIPTION = "Packages for a standalone OpenMoko SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r0"

PACKAGES = "${PN}"

RDEPENDS_${PN} += "\
    openmoko-sample2-src \
"
