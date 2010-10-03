# Using relative path here causes bitbake to search in
# BBPATH for the first instance of u-boot.inc rather
# than just within the current directory.
require recipes/u-boot/u-boot.inc

DESCRIPTION = "u-boot bootloader for OMAP3 devices"

COMPATIBLE_MACHINE = "omap3"

SRC_URI = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git;branch=${BRANCH}"
BRANCH ?= "master"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
