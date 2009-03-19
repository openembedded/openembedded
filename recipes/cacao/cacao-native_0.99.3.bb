require cacao-native.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2"

do_compile_prepend() {

	install -d ${S}/src/classes/classes/java
	install -d ${S}/src/classes/classes/gnu/java
	install -d ${S}/src/classes/classes/sun
}

