require dbus-c++_${PV}.bb
inherit native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/dbus-c++"
# actually dbus-native and expat-native, but even the bearest build machine should have that nowadays...
DEPENDS = ""
