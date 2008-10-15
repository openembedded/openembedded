require task-sdk-host.bb
FILE_PR = "r0"
DESCRIPTION = "Packages for a standalone SlugOS external toolchain"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS_${PN} += "\
    devio-sdk \
"
