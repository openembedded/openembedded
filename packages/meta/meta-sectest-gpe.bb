DESCRIPTION = "Meta-package for GPE Security Testing Image"
MAINTAINER = "Bob Davies tyggerbob@rogers.com>"
LICENSE = "MIT"
PR = "r6"

ALLOW_EMPTY = "1"
BUILD_ALL_DEPS = "1"

DEPENDS = "task-gpe"

RDEPENDS = "\
    gpe-task-base \
    gpe-base-depends \
    gpe-task-base \
    gpe-task-settings \
    gpe-task-pim \
    gpe-task-sectest"
