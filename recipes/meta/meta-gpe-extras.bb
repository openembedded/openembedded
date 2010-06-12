DESCRIPTION = "Meta-package of extra applications for the GPE Palmtop Environment"
LICENSE = "MIT"
PR = "r4"

RDEPENDS_${PN} = "\
    task-gpe-apps \
    task-gpe-games \
    task-gpe-web \
    task-gpe-desktopapps"

inherit meta
