DESCRIPTION = "Build all c7x0 kernels in one go"
SECTION = "kernel"
LICENSE = "GPL"
PROVIDES = "virtual/kernel"
PR = "r1"

COMPATIBLE_HOST = "arm.*-linux"

DEPENDS = "corgi-kernel-2.4-embedix shepherd-kernel-2.4-embedix husky-kernel-2.4-embedix"

PACKAGES = ""
EXCLUDE_FROM_WORLD = "1"

