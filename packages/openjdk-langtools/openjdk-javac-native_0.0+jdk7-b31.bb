DESCRIPTION = "Java compiler from the OpenJDK project"
HOMEPAGE = "http://http://openjdk.java.net/groups/compiler"
LICENSE  = "GPL"

PR = "r1"

DEPENDS = "openjdk-langtools-native"

PROVIDES = "virtual/javac-native"

inherit native

do_stage() {
	ln -sf sun-javac ${bindir}/javac
}
