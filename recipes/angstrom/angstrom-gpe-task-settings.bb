DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r33"

inherit task

RDEPENDS_${PN} = "\
    matchbox-panel-manager \
    mboxkbd-layouts-gui \
    gpe-su \
    gpe-conf \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"
