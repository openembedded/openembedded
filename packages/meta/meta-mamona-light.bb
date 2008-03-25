DESCRIPTION = "Meta package for Mamona"
LICENSE = "MIT"
PR = "r1"

inherit meta
EXCLUDE_FROM_WORLD = "1"

RDEPENDS = " \
task-mamona \
"

include mamona-buildall.inc

