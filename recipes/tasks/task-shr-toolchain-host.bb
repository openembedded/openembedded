require task-sdk-host.bb
PR = "r1"
DESCRIPTION = "Packages for a standalone SHR external toolchain"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

#RDEPENDS_${PN} += "\
#    devio-sdk \
#"
