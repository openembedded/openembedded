DESCRIPTION = "Meta package for Mamona"
LICENSE = "MIT"
PR = "r2"

inherit meta
EXCLUDE_FROM_WORLD = "1"

RDEPENDS_${PN} = " \
task-mamona \
"

include mamona-buildall.inc

