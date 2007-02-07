DESCRIPTION = "Meta-package for GPE Palmtop Environment Phone packages"
LICENSE = "MIT"
PR = "r0"

ALLOW_EMPTY = "1"
BUILD_ALL_DEPS = "1"

DEPENDS = "task-gpe"

RDEPENDS = "\
    gpe-base-depends \
    gpephone-task-base \
    gpephone-task-settings \
    gpephone-task-pim \
    gpeph-task-connectivity"
