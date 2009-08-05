# Java recipes which need gjar, gjavah and so on need to depend on this
# recipe.
# This makes sure we not only have the tools' bytecode but also a proper
# interpreter that can run it.
DESCRIPTION = "Provides working jar, javah etc. from the GNU Classpath project"

DEPENDS = "virtual/java-native classpath-native"

inherit native

do_stage () {
	echo 1 /dev/null
}
