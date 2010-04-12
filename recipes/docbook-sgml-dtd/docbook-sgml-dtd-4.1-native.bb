require docbook-sgml-dtd-native.inc

DTD_VERSION = "4.1"

SRC_URI = "http://docbook.org/sgml/4.1/docbk41.zip"

do_compile() {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd.html
    # for details.
		sed -i -e '/ISO 8879/d' -e '/gml/d' docbook.cat
}


SRC_URI[md5sum] = "489f6ff2a2173eb1e14216c10533ede2"
SRC_URI[sha256sum] = "deaafcf0a3677692e7ad4412c0e41c1db3e9da6cdcdb3dd32b2cc1f9c97d6311"
