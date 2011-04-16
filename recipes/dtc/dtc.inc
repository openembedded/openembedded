DESCRIPTION = "The Device Tree Compiler is a tool used to manipulate the Open-Firmware-like device tree used by PowerPC kernels."
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "flex-native bison-native"
BBCLASSEXTEND = "native"
INC_PR = "r2"

inherit autotools

do_install() {
	install -m 0755 -d ${D}${bindir}	
	install -m 0755 dtc ${D}${bindir}/dtc
	install -m 0755 -d ${D}${libdir}
	install -m 0644 libfdt/libfdt.a ${D}${libdir}/libfdt.a
	install -m 0755 -d ${D}${includedir}
	install -m 0644 libfdt/fdt.h ${D}${includedir}/fdt.h
	install -m 0644 libfdt/libfdt.h ${D}${includedir}/libfdt.h
}

NATIVE_INSTALL_WORKS = "1"
