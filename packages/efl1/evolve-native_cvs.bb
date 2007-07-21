require evolve_cvs.bb
inherit native
DEPENDS = "etk-native"

# needs ecore-x :/
BROKEN = "1"
