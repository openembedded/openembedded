DESCRIPTION = "Mason - High-performance, dynamic web site authoring system"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libexception-class-perl-native libparams-validate-perl-native \
           libcache-cache-perl-native libclass-container-perl-native"
RDEPENDS_${PN} = "libexception-class-perl libparams-validate-perl \
        libcache-cache-perl libclass-container-perl perl-module-strict \
        perl-module-warnings perl-module-file-basename perl-module-file-path \
        perl-module-file-spec perl-module-file-spec-unix perl-module-file-temp \
        perl-module-carp-heavy perl-module-io-handle perl-module-io \
        perl-module-exporter-heavy perl-module-cwd perl-module-scalar-util \
        perl-module-list-util perl-module-bytes perl-module-file-glob \
        perl-module-data-dumper"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/HTML-Mason-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Mason-${PV}"

do_stage() {
	:
}

inherit cpan_build

do_install_append () {
        # Fix up paths to the perl interpreter
        for i in ${D}${bindir}/*.pl; do
                sed -i -e "s#${STAGING_BINDIR}/perl#${bindir}/perl#g" $i
        done

        # Install the html documentation and example files
        install -m 0755 -d ${D}${docdir}/${PN}/html \
                 ${D}${docdir}/${PN}/examples/samples \
                 ${D}${docdir}/${PN}/examples/eg
        cp -pRP ${S}/htdocs ${D}${docdir}/${PN}/html
        cp -pRP ${S}/eg ${D}${docdir}/${PN}/examples/eg
        cp -pRP ${S}/samples ${D}${docdir}/${PN}/examples/samples
}

