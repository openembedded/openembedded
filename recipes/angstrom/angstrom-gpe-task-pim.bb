DESCRIPTION = "Task packages for the Angstrom distribution"
LICENSE = "MIT"
PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    gpe-timesheet \
    gpe-todo \
    gpe-calendar \
    gpe-contacts \
    gpesyncd"


