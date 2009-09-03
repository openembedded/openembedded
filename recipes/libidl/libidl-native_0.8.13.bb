SECTION = "libs"
require libidl_${PV}.bb
inherit native

DEPENDS = "flex-native glib-2.0-native"
