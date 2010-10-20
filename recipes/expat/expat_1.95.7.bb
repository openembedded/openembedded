require expat.inc
PR = "${INC_PR}.0"

SRC_URI += "file://autotools.patch \
	    file://expat-XMLCALL.patch \
	   "

inherit lib_package

do_configure () {
	rm -f ${S}/conftools/libtool.m4
	autotools_do_configure
}

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		install
}

SRC_URI[src.md5sum] = "2ff59c2a5cbdd21a285c5f343e214fa9"
SRC_URI[src.sha256sum] = "c94817c67c8ff0d244092c19f5713ea8c76a9a19075ff6031d4ef93ec7b66256"
