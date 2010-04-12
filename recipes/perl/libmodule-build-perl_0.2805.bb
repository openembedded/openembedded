DESCRIPTION = "Module::Build - Build and install Perl modules"
SECTION = "libs"
SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/Module-Build-${PV}.tar.gz"
LICENSE = "Artistic|GPL"
DEPENDS = "libyaml-perl-native libversion-perl-native \
           libextutils-cbuilder-perl-native \
           libextutils-parsexs-perl-native \
           libarchive-tar-perl-native"
RDEPENDS = "libyaml-perl libversion-perl libextutils-cbuilder-perl \
            libextutils-parsexs-perl libarchive-tar-perl"
PR = "r5"

S = "${WORKDIR}/Module-Build-${PV}"

do_stage() {
	:
}

inherit cpan_build

SRC_URI[md5sum] = "598bb59b86c2c4842eeffb03392fab5b"
SRC_URI[sha256sum] = "8fd609d1e6b460b5c95ad5612cb823aa863d51360ed55caea987909a9bab50f5"
