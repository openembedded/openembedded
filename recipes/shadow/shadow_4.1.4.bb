DESCRIPTION = "login/password utilities"
LICENSE = "GPL"

inherit autotools

SRC_URI = "ftp://pkg-shadow.alioth.debian.org/pub/pkg-shadow/shadow-${PV}.tar.gz"

S = "${WORKDIR}/shadow-${PV}"

CFLAGS_append = " -I../include"

