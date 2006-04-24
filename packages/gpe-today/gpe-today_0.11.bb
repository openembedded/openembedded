DESCRIPTION = "Displays a summary of appointments and tasks for the day ahead"
DEPENDS = "gtk+ libxrandr libxsettings libxsettings-client libgpewidget libdisplaymigration libeventdb libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

LICENSE = "GPL"
inherit gpe pkgconfig


SRC_URI = "http://www.kernelconcepts.de/~fuchs/files/${P}.tar.gz"

