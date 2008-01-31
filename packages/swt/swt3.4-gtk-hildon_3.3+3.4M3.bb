require swt3.4-gtk_${PV}.bb

PR = "r1"

DEPENDS += "hildon-1"

SRC_URI += "file://swt-hildon.patch;patch=1;pnum=2"
