DESCRIPTION = "Meta package for Mamona"
LICENSE = "MIT"
FILE_PR = "r1"

inherit meta
EXCLUDE_FROM_WORLD = "1"

RDEPENDS = " \
task-mamona \
"

include mamona-buildall.inc

