LICENSE = "GPL"
inherit gpe

DESCRIPTION = "Displays a summary of appointments and tasks for the day ahead"
DEPENDS = "gtk+ libxrandr libxsettings libxsettings-client libgpewidget libdisplaymigration libeventdb libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://makefile.patch;patch=1"
