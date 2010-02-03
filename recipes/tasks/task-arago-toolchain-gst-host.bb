DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r15"
ALLOW_EMPTY = "1"

inherit sdk

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    task-arago-toolchain-dvsdk-host \
    "
