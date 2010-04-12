DESCRIPTION = "Displays a summary of appointments and tasks for the day ahead"
DEPENDS = "gtk+ libxrandr libxsettings libxsettings-client libgpewidget libdisplaymigration libeventdb libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"

LICENSE = "GPL"
inherit gpe pkgconfig


SRC_URI = "http://www.kernelconcepts.de/~fuchs/files/${P}.tar.gz"


SRC_URI[md5sum] = "f5a9745d479879aaa1e1287a2c725ea4"
SRC_URI[sha256sum] = "f9271db0ab5bd4cdc2e09d6185320c2041f62b1e64ba7fb78cab28d104ec7d79"
