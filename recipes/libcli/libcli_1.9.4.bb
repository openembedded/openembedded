DESCRIPTION = "shared library for including a Cisco-like command-line interface into other software"
HOMEPAGE = "http://code.google.com/p/libcli/"
SECTION = "devel"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://libcli.googlecode.com/files/${PN}-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
          "

inherit autotools lib_package
