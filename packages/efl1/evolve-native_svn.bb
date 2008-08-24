require evolve_svn.bb
inherit native
DEPENDS = "etk-native"

# needs ecore-x :/
BROKEN = "1"
