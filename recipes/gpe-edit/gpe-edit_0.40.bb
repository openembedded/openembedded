DESCRIPTION = "Editor for the GPE Palmtop Environment"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"

GPE_TARBALL_SUFFIX ?= "bz2"

inherit gpe autotools

SRC_URI[md5sum] = "26bca78fb1619de3a36b6b242997339b"
SRC_URI[sha256sum] = "9aee93207a4f48b16c17bf59fe151f2a8890731b73e07bfcb73d2fcc297eb848"
