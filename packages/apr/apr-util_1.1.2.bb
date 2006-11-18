DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache License, Version 2.0"

PR = "r0"

# apache mirrors?
SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR} --with-dbm=gdbm --with-gdbm=${STAGING_DIR}/${HOST_SYS} --with-expat=${STAGING_DIR}/${HOST_SYS}"

inherit autotools lib_package binconfig

do_configure() {
  oe_runconf
}

do_stage() {
  oe_libinstall -a -so -C .libs libaprutil-1 ${STAGING_LIBDIR}
}
