DESCRIPTION = "Meta-package for GPE Security Testing Image"
LICENSE = "MIT"
PR = "r7"

RDEPENDS_${PN} = "\
    gpe-task-base \
    gpe-base-depends \
    gpe-task-base \
    gpe-task-settings \
    gpe-task-pim \
    gpe-task-sectest"

inherit meta
