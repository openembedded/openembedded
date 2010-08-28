DESCRIPTION = "Meta-package for maemo environment"
LICENSE = "MIT"
PR = "r1"

RDEPENDS_${PN} = "\
    maemo-task-base \
    maemo-task-apps \
    maemo-task-libs-install \
    maemo-task-theme"

inherit meta
