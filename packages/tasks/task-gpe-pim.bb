DESCRIPTION = "PIM task packages for GPE Palmtop Environment"
FILE_PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-timesheet \
    gpe-todo \
    gpe-calendar \
    gpe-sketchbook \
    gpe-contacts \
    gpe-synctool \
    gpesyncd \
    miniclipboard"

# broken    gpe-today \ 


