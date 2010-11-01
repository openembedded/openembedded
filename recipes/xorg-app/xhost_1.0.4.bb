require xorg-app-common.inc
DESCRIPTION = "Server access control program for X"
LICENSE = "MIT"
DEPENDS += "libxmu libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "2be663a0afbcc0856c1591477d5bf32a"
SRC_URI[archive.sha256sum] = "5e02c06caeb7a258f3621bf11459a7820cfeaf9bf269c1f8da86d7071346a594"
