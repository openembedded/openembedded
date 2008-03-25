DESCRIPTION = "Meta package for Mamona"
LICENSE = "MIT"
PR = "r1"

inherit meta
EXCLUDE_FROM_WORLD = "1"

RDEPENDS = " \
task-mamona-base \
task-mamona-devel \
task-mamona-extras \
task-mamona-nokia-it \
task-mamona-noemu \
task-mamona-e \
"

include mamona-buildall.inc
