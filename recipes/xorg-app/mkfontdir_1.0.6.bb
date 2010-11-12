require xorg-app-common.inc
DESCRIPTION = "a program to create an index of X font files in a directory"
RDEPENDS_${PN} += "mkfontscale"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dc342dd8858416254bb5f71a9ddce589"
SRC_URI[archive.sha256sum] = "55d56c6310f8d2268cb8978e838d01d27c7d70e30282c373c5a935ab3fb8c859"

BBCLASSEXTEND = "native"
