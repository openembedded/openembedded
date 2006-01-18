DESCRIPTION = "Meta-package for GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "MIT"
PR = "r42"

ALLOW_EMPTY = "1"
BUILD_ALL_DEPS = "1"

DEPENDS = "task-gpe"

RDEPENDS = "\
    gpe-base-depends \
    gpe-task-base \
    gpe-task-settings \
    gpe-task-pim \
    gpe-task-apps \
    gpe-task-games \
    gpe-task-connectivity"
