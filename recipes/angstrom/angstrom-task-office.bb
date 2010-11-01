DESCRIPTION = "Task packages for the Angstrom distribution"
LICENSE = "MIT"
PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    gnumeric \
    abiword \
    imposter \
    evince \
    gqview"

