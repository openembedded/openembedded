require gobject-introspection_${PV}.bb
PR = "r0"

inherit native
DEPENDS = "glib-2.0-native bison-native flex-native python-native python-cython-native libffi-native"
