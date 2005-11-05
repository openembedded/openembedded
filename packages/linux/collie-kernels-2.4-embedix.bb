DESCRIPTION = "Build all collie kernels in one go"
SECTION = "kernel"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
LICENSE = "GPL"
PROVIDES = "virtual/kernel"
PR = "r2"

COMPATIBLE_HOST = "arm.*-linux"

DEPENDS = '${@base_conditional("DISTRO_TYPE", "debug", "openzaurus-sa", "collie-kernel-24-8 collie-kernel-32-0 collie-kernel-32-32 collie-kernel-40-24 collie-kernel-48-16 collie-kernel-58-6 collie-kernel-64-0",d)}'
PACKAGES = ""
EXCLUDE_FROM_WORLD = "1"

