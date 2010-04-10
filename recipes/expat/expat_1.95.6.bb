require expat.inc

PR = "r2"

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		install
}

SRC_URI[src.md5sum] = "ca78d94e83e9f077b5da2bfe28ba986a"
SRC_URI[src.sha256sum] = "b48761f9b67715bb1f85371d0059d744a60ed71e72065da7d5326bbb04e26a92"
