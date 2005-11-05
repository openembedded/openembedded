inherit update-alternatives

DESCRIPTION = "Dictionary file for libdictionary"
DEPENDS = "zip-native perl-native"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "http://ftp.services.openoffice.org/pub/OpenOffice.org/contrib/dictionaries/en_GB.zip"

ALTERNATIVE_NAME = "dictionary"
ALTERNATIVE_LINK = "${datadir}/dictionary/dictionary"
ALTERNATIVE_PATH = "${datadir}/dictionary/en_GB"
ALTERNATIVE_PRIORITY = "50"

do_compile() {
	perl -ne ' s,/.*,,; next if ( /[.1-9]/ || /^.{0,1}$/ ); print;' ${WORKDIR}/en_GB.dic | sort > en_GB
}

FILES_${PN} = "${datadir}/dictionary"

do_install() {
	install -d ${D}/${datadir}/dictionary
	install ${S}/en_GB ${D}/${datadir}/dictionary/
}

