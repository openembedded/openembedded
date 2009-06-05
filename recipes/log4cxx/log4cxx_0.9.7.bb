DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = "Apache License, Version 2.0"
HOMEPAGE = "http://logging.apache.org/log4cxx/"
# PV = "0.10.0"
PR = "r1"

SRC_URI = "http://archive.apache.org/dist/logging/log4cxx/log4cxx-0.9.7.tar.gz \
          file://log4cxx097.patch;patch=1"

#build this:
S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
