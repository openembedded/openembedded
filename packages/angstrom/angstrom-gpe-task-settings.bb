DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    matchbox-panel-manager \
    gpe-su \
    gpe-conf \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"
