DESCRIPTION = "shared library for including a Cisco-like command-line interface into other software"
HOMEPAGE = "http://code.google.com/p/libcli/"
SECTION = "devel"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://libcli.googlecode.com/files/${PN}-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
          "

inherit autotools lib_package

SRC_URI[md5sum] = "b917617d21b90db214971efe64a33416"
SRC_URI[sha256sum] = "c1e56ff2e55a879b7c89b5808aea76063512d9a24cffd601aa3d9a84cd6a7928"
