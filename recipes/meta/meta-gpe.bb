DESCRIPTION = "Meta-package for GPE Palmtop Environment"
LICENSE = "MIT"
PR = "r44"

RDEPENDS_${PN} = "\
    task-gpe-base \
    task-gpe-settings \
    task-gpe-pim \
    task-gpe-apps \
    task-gpe-games \
    task-gpe-connectivity"

inherit meta
