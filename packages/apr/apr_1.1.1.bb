DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
LICENSE = "Apache License, Version 2.0"

PR = "r0"

# apache mirrors?
SRC_URI = "http://mirror.switch.ch/mirror/apache/dist/apr/${P}.tar.bz2"

inherit autotools lib_package binconfig

do_configure() {
  oe_runconf
}

do_stage() {
  oe_libinstall -a -so -C .libs libapr-1 ${STAGING_LIBDIR}
}
