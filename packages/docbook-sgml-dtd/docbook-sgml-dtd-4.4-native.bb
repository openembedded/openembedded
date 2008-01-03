require docbook-sgml-dtd-native.inc

DTD_VERSION = "4.4"

do_compile() {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd.html
    # for details.
		sed -i -e '/ISO 8879/d' -e '/gml/d' docbook.cat
}

