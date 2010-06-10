DESCRIPTION = "Meta-package for QPE stuff"
SECTION = "opie/base"
LICENSE = "MIT"
PR = "r4"

RDEPENDS_${PN} = " \
    task-qpe-applets \
    task-qpe-games \
    task-qpe-inputmethods \
    task-qpe-multimedia \
    task-qpe-emulators \
    task-qpe-applications \
    task-qpe-fonts \
    task-qpe-settings"

inherit meta
