DESCRIPTION="prerequisites for xmltv"

PARALLEL_MAKE = ""
SRC_URI="http://downloads.sourceforge.net/xmltv/xmltv-${PV}.tar.bz2"

DEPENDS = "perl libxml-parser-perl-native libwww-perl-native libdate-manip-perl-native \
		libxml-twig-perl-native libxml-writer-perl-native libfile-slurp-perl-native \
		libtermreadkey-perl-native"

PR = "r0"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan
