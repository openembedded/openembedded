# Copyright (C) 2010 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "PatchELF is a small utility to modify the dynamic linker and RPATH of ELF executables."
HOMEPAGE = "http://nixos.org/patchelf.html"
LICENSE = "GPLv3"
SECTION = "devel"
DEPENDS = ""
PR = "r0"

SRC_URI = "http://hydra.nixos.org/build/114505/download/2/patchelf-${PV}.tar.bz2"

SRC_URI[md5sum] = "c41fc98091d15dc93ba876c3ef11f43c"
SRC_URI[sha256sum] = "24b9a850af45e1a277e234b9eb090b52305a2e1c6b02addeb3ae98b4b49d37ce"

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
