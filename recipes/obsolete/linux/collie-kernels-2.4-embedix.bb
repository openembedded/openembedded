DESCRIPTION = "Build all collie kernels in one go"
SECTION = "kernel"
LICENSE = "GPLv2"
PROVIDES = "virtual/kernel"
PR = "r2"

COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "collie"
COMPATIBLE_MACHINE = "none"


DEPENDS = '${@base_conditional("DISTRO_TYPE", "debug", "openzaurus-sa", "collie-kernel-64-0 collie-kernel-24-8 collie-kernel-32-0 collie-kernel-32-32 collie-kernel-40-24 collie-kernel-48-16 collie-kernel-58-6",d)}'
PACKAGES = ""
EXCLUDE_FROM_WORLD = "1"

