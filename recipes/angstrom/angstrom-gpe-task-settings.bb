DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r36"

inherit task

RDEPENDS_${PN} = "\
    matchbox-panel-manager \
    mboxkbd-layouts-gui \
	gpe-su \
    gpe-conf \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"
