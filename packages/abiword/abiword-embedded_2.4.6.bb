require abiword.inc

EXTRA_OECONF += "--enable-embedded"

RCONFLICTS = "abiword"
RPROVIDES += "abiword"

do_compile_prepend() {
	cp ${S}/src/af/xap/unix/hildon/xap_EmbeddedFeatures.h ${S}/src/af/xap/unix/
	cp ${S}/src/wp/ap/unix/hildon/ap_EmbeddedFeatures.h ${S}/src/wp/ap/unix/
}

