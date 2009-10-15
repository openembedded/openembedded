require imagemagick_${PV}.bb
DEPENDS ="libtool-native"
inherit native

SRC_URI_append = " file://fix_open_file.patch;patch=1"
