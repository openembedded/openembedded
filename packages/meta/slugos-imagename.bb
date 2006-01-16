# This is an inglorious hack to provide a package to match
# ${SLUGOS_IMAGENAME}-image
MAINTAINER = "John Bowler <jbowler@acm.org>
LICENSE = "MIT"
PN = "${SLUGOS_IMAGENAME}-image"
PV = "0"
PR = "r0"
DEPENDS = "slugos-image"
PACKAGES = ""
INHIBIT_DEFAULT_DEPS = "1"

SLUGOS_IMAGENAME ?= "slugos"

do_fetch() {
}
do_unpack() {
}
do_patch() {
}
do_configure() {
}
do_compile() {
}
do_install() {
}
do_stage() {
}
do_build() {
}
