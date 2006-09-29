DESCRIPTION = "Module::Build - Build and install Perl modules"
SECTION = "libs"
SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/Module-Build-0.2805.tar.gz"
LICENSE = "Artistic|GPL"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
DEPENDS = "libyaml-perl-native libversion-perl-native \
           libextutils-cbuilder-perl-native \
           libextutils-parsexs-perl-native \
           libarchive-tar-perl-native"
RDEPENDS = "libyaml-perl libversion-perl libextutils-cbuilder-perl \
            libextutils-parsexs-perl libarchive-tar-perl"
PR = "r3"

S = "${WORKDIR}/Module-Build-${PV}"

inherit cpan_build
