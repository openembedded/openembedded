require docbook-sgml-dtd-native.inc

DTD_VERSION = "4.4"

do_compile() {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd.html
    # for details.
		sed -i -e '/ISO 8879/d' -e '/gml/d' docbook.cat
}


SRC_URI[md5sum] = "f89e1bd0b2c7a361e3f1f739e16b5d0d"
SRC_URI[sha256sum] = "0ac7960409b032c8e517483523ecb92af4e59196a33b3e2c5617daa22b7a8a6c"
