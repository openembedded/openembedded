require docbook-sgml-dtd-native.inc

DTD_VERSION = "3.1"

SRC_URI = "http://www.docbook.org/sgml/3.1/docbk31.zip;md5sum=432749c0c806dbae81c8bcb70da3b5d3"

do_compile() {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd-3.html
    # for details.
    sed -i -e '/ISO 8879/d' -e 's|DTDDECL "-//OASIS//DTD DocBook V3.1//EN"|SGMLDECL|g' docbook.cat
}


SRC_URI[md5sum] = "432749c0c806dbae81c8bcb70da3b5d3"
SRC_URI[sha256sum] = "20261d2771b9a052abfa3d8fab1aa62be05791a010281c566f9073bf0e644538"
