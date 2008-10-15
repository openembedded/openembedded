DESCRIPTION = "Task packages for the Angstrom distribution"
FILE_PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    cups \
#    gnome-cups-manager \
    "
