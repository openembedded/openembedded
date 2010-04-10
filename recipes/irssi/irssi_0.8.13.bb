DESCRIPTION = "Irssi is a modular IRC client with Perl scripting."
HOMEPAGE = "http://irssi.org/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS += "ncurses glib-2.0"

PACKAGES += "${PN}-common"
FILES_${PN} = "${bindir}/irssi"
FILES_${PN}-common = "${datadir}/irssi ${sysconfdir}"
RDEPENDS_${PN} += "${PN}-common"

inherit autotools

SRC_URI = "http://www.irssi.org/files/${P}.tar.bz2 \
"

EXTRA_OECONF = "--enable-ipv6 \
		--disable-ssl \
		--disable-glibtest \
		--without-socks \
		--with-textui \
		--without-bot \
		--without-proxy \
		--with-perl=no \
		--with-ncurses=${STAGING_LIBDIR}/.."

do_configure () {
	# create help files
	echo "Creating help files..."
	perl syntax.pl

	files=`echo docs/help/in/*.in|sed -e 's,docs/help/in/Makefile.in ,,' -e 's,docs/help/in/,!,g' -e 's/\.in /.in ?/g'`
	cat docs/help/in/Makefile.am.gen|sed "s/@HELPFILES@/$files/g"|sed 's/?/\\?/g'|tr '!?' '\t\n' > docs/help/in/Makefile.am

	files=`echo $files|sed 's/\.in//g'`
	cat docs/help/Makefile.am.gen|sed "s/@HELPFILES@/$files/g"|sed 's/?/\\?/g'|tr '!?' '\t\n' > docs/help/Makefile.am

	# .HTML -> .txt with lynx
	# echo "Documentation: html -> txt..."
	# lynx -dump -nolist docs/faq.html|perl -pe 's/^ *//; if ($_ eq "\n" && $state eq "Q") { $_ = ""; } elsif (/^([QA]):/) { $state = $1 } elsif ($_ ne "\n") { $_ = "   $_"; };' > docs/faq.txt
	> docs/faq.txt

	autotools_do_configure
}

do_stage () {
	find . -name \*.h | for h in `cat`; do
		install -d ${STAGING_LIBDIR}/../irssi/`dirname $h`
		install -m 0644 $h ${STAGING_LIBDIR}/../irssi/$h
	done
	find . -name lib\*.a | for l in `cat`; do
		install -d ${STAGING_LIBDIR}/../irssi/`dirname $l`
		install -m 0644 $l ${STAGING_LIBDIR}/../irssi/$l
	done
	install -m 0644 irssi-config ${STAGING_LIBDIR}/../irssi/
}

do_install () {
	autotools_do_install
	rm -f ${D}${docdir}/irssi/faq.txt
}

SRC_URI[md5sum] = "0d6fc2203832b514eff014fffd574664"
SRC_URI[sha256sum] = "896541ac837421290934e2658ab364d4d3f0326259489a94a0cd166e2b05d735"
