require xorg-app-common.inc
PE = "1"

#DESCRIPTION = ""

DEPENDS += " virtual/libx11"
FILES_${PN} += "  /usr/lib/X11/xinit"


SRC_URI[archive.md5sum] = "f04a903cc0e18b3c338f58eb90f6caf8"
SRC_URI[archive.sha256sum] = "c77a58cba815eb1dde2242a819e80d7d84d753678837ac24d385e3ec65d33186"
