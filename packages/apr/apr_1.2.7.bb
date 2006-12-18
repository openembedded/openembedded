DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
LICENSE = "Apache License, Version 2.0"

PR = "r1"

# apache mirrors?
SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.bz2"

inherit autotools lib_package binconfig

do_configure() {
  oe_runconf
}

do_stage() {
  autotools_stage_all
}
