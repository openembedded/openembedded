SECTION = "libs"
include ncurses_${PV}.bb
inherit native
EXTRA_OEMAKE = '"BUILD_CCFLAGS=${BUILD_CCFLAGS}"'
DEPENDS = ""
