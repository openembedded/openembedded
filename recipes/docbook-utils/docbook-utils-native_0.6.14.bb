SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "openjade-native sgmlspl-native docbook-dsssl-stylesheets-native docbook-sgml-dtd-3.1-native"
PR = "r3"

SRC_URI = "\
	ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/docbook-utils-${PV}.tar.gz \
	file://re.patch \
"

SRC_URI[md5sum] = "6b41b18c365c01f225bc417cf632d81c"
SRC_URI[sha256sum] = "48faab8ee8a7605c9342fb7b906e0815e3cee84a489182af38e8f7c0df2e92e9"

S = "${WORKDIR}/docbook-utils-${PV}"

inherit autotools native

do_configure_prepend() {
    # Prevents the jw script to search on the build system.
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" bin/jw.in
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" doc/man/Makefile.am
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" doc/HTML/Makefile.am
}
do_install () {
    install -d ${D}${bindir}
    # Installs the binaries and a bunch of other commonly used names for them.
    for doctype in html ps dvi man pdf rtf tex texi txt
    do
        install -m 0755 ${S}/bin/docbook2$doctype ${D}${bindir}/
        ln -sf docbook2x-$doctype ${D}${bindir}/db2$doctype
        ln -sf docbook2$doctype ${D}${bindir}/db2$doctype
        ln -sf docbook2$doctype ${D}${bindir}/docbook-to-$doctype
    done
    install -m 0755 ${S}/bin/jw ${D}${bindir}/
    for i in backends/dvi backends/html backends/man \
        backends/pdf backends/ps backends/rtf backends/tex \
        backends/texi backends/txt frontends/docbook \
        helpers/docbook2man-spec.pl helpers/docbook2texi-spec.pl \
        docbook-utils.dsl; do
            install -d ${D}${datadir}/sgml/docbook/utils-${PV}/`dirname $i`
            install ${S}/$i ${D}${datadir}/sgml/docbook/utils-${PV}/$i
        done
}
