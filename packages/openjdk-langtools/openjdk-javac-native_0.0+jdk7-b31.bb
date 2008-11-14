DESCRIPTION = "Java compiler from the OpenJDK project"
HOMEPAGE = "http://http://openjdk.java.net/groups/compiler"
LICENSE  = "GPL"

PR = "r0"

DEPENDS = "openjdk-langtools-native"

PROVIDES = "virtual/javac-native"

do_stage() {
	ln -sf ${bindir}/sun-javac ${bindir}/javac
}
