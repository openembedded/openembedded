require xapian-quickstartindex_${PV}.bb

DEPENDS = "xapian-core-native"

inherit native

do_stage() {
        install -m 0744 ${WORKDIR}/${BINARY_NAME} ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "841603b0b16162b3b47f9f85cb2e1dfd"
SRC_URI[sha256sum] = "8ed21bd84253d3d09a67481d3b441b6410a173b65c952c3e9e2e1c7b67aea6c8"
#CHECKSUMS.INI MISMATCH: I got this instead:
#SRC_URI[md5sum] = "757f72c82e68c2422286e6b6299a3652"
#SRC_URI[sha256sum] = "58ccae4d28fb6434558764132d5c4e1d87a3134e4acb11eb11f92d2a748118f4"
