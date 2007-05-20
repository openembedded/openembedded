require mono_1.2.4.inc
DEPENDS = "mono-native glib-2.0"

PR = "r3"
SRC_URI += "file://mono-monoburg-Makefile.patch;patch=1 \
	    file://mono-mips-endian.patch;patch=1 \
	    file://mono-configure.patch;patch=1 \
	    file://mono-mini-Makefile.patch;patch=1 \
	    "

do_install_append() {
	install -d ${D}${libdir}/mono/1.0/
	cp ${S}/mcs/class/lib/monolite/* ${D}${libdir}/mono/1.0/
}

PACKAGES =+ "mono-dll"
FILES_mono-dll = "${libdir}/mono/1.0/"


