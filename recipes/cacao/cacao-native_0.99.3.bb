require cacao-native.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2"

do_compile_prepend() {

	install -d ${S}/src/classes/classes/java
	install -d ${S}/src/classes/classes/gnu/java
	install -d ${S}/src/classes/classes/sun
}


SRC_URI[md5sum] = "db93ab31c6d1b7f1e213771bb81bde58"
SRC_URI[sha256sum] = "1ea5bd257f755ffcae2c7a1935c37147c7392478922410e0870361eea08b6c27"
