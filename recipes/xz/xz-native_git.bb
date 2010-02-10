# XZ_BASE should be the latest released version of xz.
# It can be set in the distro file.
#XZ_BASE ?= "4.999.9"
#SRCREV = "HEAD"
#PV = "${XZ_BASE}+gitr${SRCREV}"
PV = "git"
require xz-native.inc
