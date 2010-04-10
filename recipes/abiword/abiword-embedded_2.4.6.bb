require abiword.inc

EXTRA_OECONF += "--enable-embedded"

RCONFLICTS = "abiword"
RPROVIDES += "abiword"

do_compile_prepend() {
	cp ${S}/src/af/xap/unix/hildon/xap_EmbeddedFeatures.h ${S}/src/af/xap/unix/
	cp ${S}/src/wp/ap/unix/hildon/ap_EmbeddedFeatures.h ${S}/src/wp/ap/unix/
}


SRC_URI[md5sum] = "30fbd0a9b539f15f54f90d3812a75266"
SRC_URI[sha256sum] = "98105f03b1f33f26cddbfc18d64b04e64a85db3c861508837ab290d26ca2fed3"
