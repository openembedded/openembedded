DESCRIPTION = "Build all c7x0 kernels in one go"
SECTION = "kernel"
LICENSE = "GPLv2"
PROVIDES = "virtual/kernel"
PR = "r1"

COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "(corgi|husky|shepherd)"
COMPATIBLE_MACHINE = "none"

DEPENDS = "corgi-kernel-2.4-embedix shepherd-kernel-2.4-embedix husky-kernel-2.4-embedix"

PACKAGES = ""
EXCLUDE_FROM_WORLD = "1"

