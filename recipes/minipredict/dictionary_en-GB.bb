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


SRC_URI[md5sum] = "6fb885d57899c3e6aa2b27f3510deb37"
SRC_URI[sha256sum] = "f4b43083923e2998298fd270a8a9f9ed570f4fbebeaa46ce5f1788b76920308b"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "218909136738f4564b81ecd145ade6ee"
#SRC_URI[sha256sum] = "5869d8bd80eb2eb328ebe36b356348de4ae2acb1db6df39d1717d33f89f63728"
