require task-sdk-host.bb

DESCRIPTION = "Packages for a standalone Openmoko SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r2"

PACKAGES = "${PN}"

RDEPENDS_${PN} += "\
    openmoko-sample2-src \
    openmoko-toolchain-scripts \
    edje-sdk \
"
