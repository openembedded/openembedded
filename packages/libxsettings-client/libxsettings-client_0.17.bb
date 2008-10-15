require libxsettings-client.inc

DEPENDS += "gtk-doc"
FILE_PR ="r2"

SRC_URI += "file://no-host-includes.patch;patch=1 "
