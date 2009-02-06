DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r34"

inherit task

RDEPENDS_${PN} = "\
    matchbox-panel-manager \
    mboxkbd-layouts-gui \
    connman-gnome \
	gpe-su \
    gpe-conf \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"
