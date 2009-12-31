DESCRIPTION="prerequisites for xmltv"

PARALLEL_MAKE = ""
SRC_URI="http://downloads.sourceforge.net/xmltv/xmltv-${PV}.tar.bz2 \
         file://Makefile.PL.patch;patch=1"

RDEPENDS = "perl libxml-parser-perl libwww-perl libdate-manip-perl \
		libxml-twig-perl libxml-writer-perl libfile-slurp-perl \
		libtermreadkey-perl libarchive-zip-perl libio-zlib-perl \
		libdate-manip-perl \
                libhtml-treebuilder-perl libwww-mechanize-perl"
DEPENDS = "perl libxml-parser-perl-native libwww-perl-native libdate-manip-perl-native \
		libxml-twig-perl-native libxml-writer-perl-native libfile-slurp-perl-native \
		libtermreadkey-perl-native libarchive-zip-perl-native libio-zlib-perl-native \
		libdate-manip-perl-native \
                libhtml-treebuilder-perl-native libwww-mechanize-perl-native"

PR = "r2"

# cpan does not work, it installs things in the perl work dir iso the xmltv work dir
# root cause are bad definitions in perl/config.sh, but I don't know what they should be
# so for now commented out the cpan stuff and do the work myself.
#EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

#inherit cpan

FILES_${PN} += "${libdir}"

do_configure() {
        perl Makefile.PL PREFIX=/usr
        sed -i -e 's,$(FIXIN),echo,g' \
               -e 's,^FIXIN.*,,g' Makefile
}


do_install() {
	oe_runmake install DESTDIR=${D}
}
