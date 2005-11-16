# libdbi-drivers OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Database Drivers for libdbi"
HOMEPAGE = "http://libdbi-drivers.sourceforge.net/"
LICENSE = "GPLv2"
SECTION = "libs"
MAINTAINER = "Eddy Pronk <epronk@muftor.com>"

PROVIDES = "libdbd-sqlite"
DEPENDS = "libdbi sqlite"

SRC_URI = "${SOURCEFORGE_MIRROR}/libdbi-drivers/libdbi-drivers-${PV}.tar.gz"

inherit autotools

PACKAGES = "libdbd-sqlite"

EXTRA_OECONF = "--with-dbi-incdir=${STAGING_INCDIR} \
                --with-sqlite \
                --with-sqlite-libdir=${STAGING_LIBDIR} \
                --with-sqlite-incdir=${STAGING_INCDIR}"

FILES_libdbd-sqlite = "/usr/lib/dbd/libsqlite.so \
                       /usr/lib/dbd/libsqlite.la \
                       /usr/lib/dbd/libsqlite.a"

DESCRIPTION_libdbd-sqlite = "SQLite database driver for libdbi"
        
do_configure_old () {
  ./configure \
		    --build=${BUILD_SYS} \
		    --host=${HOST_SYS} \
		    --target=${TARGET_SYS} \
		    --prefix=${prefix} \
		    --with-sqlite \
		    --with-sqlite-libdir=${STAGING_LIBDIR} \
		    --with-sqlite-incdir=${STAGING_INCDIR}
}
        