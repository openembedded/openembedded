DESCRIPTION="xmltv; epg grabbers for e.g. mythtv"

PARALLEL_MAKE = ""
SRC_URI="http://downloads.sourceforge.net/xmltv/xmltv-${PV}.tar.bz2 \
         file://Makefile.PL.patch;patch=1"

RDEPENDS = "perl \
            libarchive-zip-perl \
            libdate-manip-perl \
            libdatetime-format-strptime-perl \
            libfile-slurp-perl \
            libhtml-parser-perl \
            libhtml-treebuilder-perl \
	    libhttp-cache-transparent-perl \
            libio-stringy-perl libxml-dom-perl \
            libio-zlib-perl \
	    liblingua-en-numbers-ordinate \
	    liblinux-dvb-perl \
            libsoap-lite-perl \
            libterm-progressbar-perl \
            libtermreadkey-perl \
            libtimedate-perl \
	    libunicode-string-perl \
	    libunicode-utf8simple-perl \
            libwww-mechanize-perl \
            libwww-perl \
            libxml-parser-perl \
            libxml-twig-perl \
            libxml-writer-perl \
            perl-module-exporter-heavy \
            perl-module-file-glob \
            perl-module-getopt-long \
            "

DEPENDS = "perl \
           libarchive-zip-perl-native \
           libdate-manip-perl-native \
           libdatetime-format-strptime-perl-native \
           libfile-slurp-perl-native \
           libhtml-parser-perl-native \
           libhtml-treebuilder-perl-native \
	   libhttp-cache-transparent-perl-native \
           libio-stringy-perl-native \
           libio-zlib-perl-native \
	   liblingua-en-numbers-ordinate-native \
	   liblinux-dvb-perl-native \
           libsoap-lite-perl-native \
           libterm-progressbar-perl-native \
           libtermreadkey-perl-native \
           libtimedate-perl-native \
	   libunicode-string-perl-native \
	   libunicode-utf8simple-perl-native \
           libwww-mechanize-perl-native \
           libwww-perl-native \
           libxml-dom-perl-native \
           libxml-parser-perl-native \
           libxml-twig-perl-native \
           libxml-writer-perl-native \
           "

PR = "r4"

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
