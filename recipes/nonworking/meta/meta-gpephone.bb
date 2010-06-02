DESCRIPTION = "Meta-package for GPE Palmtop Environment Phone packages"
LICENSE = "MIT"
PR = "r1"

RDEPENDS_${PN} = "\
    gpephone-task-base \
    gpephone-task-settings \
    gpephone-task-pim \
    gpephone-task-connectivity"

inherit meta
